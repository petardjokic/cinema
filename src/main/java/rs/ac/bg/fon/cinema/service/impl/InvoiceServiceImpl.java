package rs.ac.bg.fon.cinema.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.domain.InvoiceItem;
import rs.ac.bg.fon.cinema.exception.ServiceException;
import rs.ac.bg.fon.cinema.mapper.InvoiceItemMapper;
import rs.ac.bg.fon.cinema.mapper.InvoiceMapper;
import rs.ac.bg.fon.cinema.service.DisplayService;
import rs.ac.bg.fon.cinema.service.HallService;
import rs.ac.bg.fon.cinema.service.InvoiceService;
import rs.ac.bg.fon.cinema.service.TicketService;
import rs.ac.bg.fon.cinema.service.dto.InvoiceSearchRequest;
import rs.ac.bg.fon.cinema.service.dto.TicketSearchRequest;
import rs.ac.bg.fon.cinema.service.validation.InvoiceCancelationValidation;
import rs.ac.bg.fon.cinema.service.validation.InvoiceSave;

@Service
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceMapper invoiceMapper;
	
	@Autowired
	private InvoiceItemMapper invoiceItemMapper;

	@Autowired
	private TicketService ticketService;

	@Autowired
	private DisplayService displayService;
	
	@Autowired
	private HallService hallService;
	
	@Autowired
	private InvoiceCancelationValidation cancelInvoiceValidation;
	
	@Autowired
	private InvoiceSave saveInvoiceValidation;

	@Override
	public Invoice getInvoiceById(Long invoiceId) {
		Invoice invoice = invoiceMapper.getById(invoiceId);
		
		Optional.ofNullable(invoice).orElseThrow(() ->
			new ServiceException(String.format("Invoice with ID  %s does not exist", invoiceId)));
	
		List<InvoiceItem> items = invoiceItemMapper.searchInvoiceItems(TicketSearchRequest.builder().invoiceId(invoiceId).build());
		invoice.setItems(items);
		return invoice;
	}


	@Override
	@Transactional
	public Invoice saveInvoice(Invoice invoice) {
		log.info("Saving invoice: {}", invoice);
		invoice.setIssuedAt(LocalDateTime.now());
		invoice.setActive(true);
		Double totalPrice = invoice.getItems().stream().map(item -> item.getPrice()).reduce(0d, (x,y) -> x+y);
		invoice.setTotalPrice(totalPrice);
		saveInvoiceValidation.validate(invoice);
		invoiceMapper.save(invoice);
		invoice.getItems().forEach(item -> {
			item.setInvoiceId(invoice.getId());
			item.setActive(true);
			log.info("Saving item: {}", item);
			invoiceItemMapper.save(item);
		});
		return invoice;
	}

	@Override
	public Invoice freeze(Long invoiceId) {
		Invoice invoice = getInvoiceById(invoiceId);
		cancelInvoiceValidation.validate(invoice);
		
//		if(!invoice.getActive())
//			throw new IllegalStateException("Invoice already freezed");
//		
//		boolean doesAnyDisplayStarted = invoice.getTickets().stream()
//			.map(ticket -> displayService.getDisplayByIdEager(ticket.getDisplayId()))
//			.anyMatch(display -> display.getStartsAt().isAfter(LocalDateTime.now()));
//		if(doesAnyDisplayStarted) 
//			throw new IllegalStateException("Cannot freeze invoice. Some displays already started");
		
		return freezeInvoice(invoice);
	}
	
	@Transactional
	public Invoice freezeInvoice(Invoice invoice) {
		invoiceMapper.freezeInvoice(invoice.getId());
		invoiceItemMapper.freezeByInvoiceId(invoice.getId());
		return getInvoiceById(invoice.getId()); // getInvoiceDtoById(invoice.getId());
	}


	@Override
	public List<Invoice> getAll() {
		return invoiceMapper.getAll();
	}


	@Override
	public List<Invoice> search(InvoiceSearchRequest request) {
		return invoiceMapper.search(request);
	}
}
