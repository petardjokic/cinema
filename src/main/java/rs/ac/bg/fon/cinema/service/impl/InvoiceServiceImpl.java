package rs.ac.bg.fon.cinema.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.mapper.InvoiceMapper;
import rs.ac.bg.fon.cinema.service.InvoiceService;
import rs.ac.bg.fon.cinema.service.TicketService;
import rs.ac.bg.fon.cinema.service.dto.InvoiceDto;
import rs.ac.bg.fon.cinema.service.dto.TicketDto;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceMapper invoiceMapper;
	
	@Autowired 
	private TicketService ticketService;
	
//	@Autowired
//	private DisplayService displayService;
	
	@Override
	public InvoiceDto getInvoiceById(Long invoiceId) {
		Invoice invoice = invoiceMapper.getById(invoiceId);
		List<TicketDto> tickets = ticketService.getTicketByInvoiceId(invoice.getId());
		return convertToDto(invoice, tickets);
	}

	private InvoiceDto convertToDto(Invoice invoice, List<TicketDto> tickets) {
		return InvoiceDto.builder().id(invoice.getId()).issuedAt(invoice.getIssuedAt()).active(invoice.getActive()).tickets(tickets).build();
	}

	@Override
	@Transactional
	public Invoice saveInvoice(InvoiceDto invoiceDto) {
		Invoice invoice = convertDtoToInvoice(invoiceDto);
		invoice= invoiceMapper.save(invoice);
		ticketService.saveInvoiceTickets(invoice.getId(), invoiceDto.getTickets());
		return invoice;
	}

	private Invoice convertDtoToInvoice(InvoiceDto invoiceDto) {
		return Invoice.builder().id(invoiceDto.getId()).issuedAt(invoiceDto.getIssuedAt()).active(invoiceDto.getActive()).build();
	}

}
