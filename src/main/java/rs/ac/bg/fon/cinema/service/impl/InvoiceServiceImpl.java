package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.domain.InvoiceDto;
import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.mapper.InvoiceMapper;
import rs.ac.bg.fon.cinema.service.DisplayService;
import rs.ac.bg.fon.cinema.service.InvoiceService;
import rs.ac.bg.fon.cinema.service.TicketService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceMapper invoiceMapper;

	@Autowired
	private TicketService ticketService;

	@Autowired
	private DisplayService displayService;

	@Override
	public Invoice getInvoiceById(Long invoiceId) {
		Invoice invoice = invoiceMapper.getById(invoiceId);
		List<Ticket> tickets = ticketService.getTicketByInvoiceId(invoice.getId());
		invoice.setTickets(tickets);
		return invoice;
	}

	@Override
	public InvoiceDto getInvoiceDtoById(Long invoiceId) {
		Invoice invoice = invoiceMapper.getById(invoiceId);
		List<Ticket> tickets = ticketService.getTicketByInvoiceId(invoice.getId());
		
		List<Display> events = tickets.stream()
			.map(ticket -> displayService.getDisplayById(ticket.getDisplayId()))
			.collect(Collectors.toList());
		
		events.forEach(display -> {
			List<Ticket> displayTickets = tickets.stream()
			.filter(ticket -> display.getId().equals(ticket.getDisplayId()))
			.collect(Collectors.toList());
			display.setTickets(displayTickets);
			display.setSeatsAvailability(null);
		});
		return InvoiceDto.builder()
				.id(invoice.getId())
				.issuedAt(invoice.getIssuedAt())
				.active(invoice.getActive())
				.events(events)
				.build();
	}

	@Override
	@Transactional
	public Invoice saveInvoice(Invoice invoiceDto) {
		Invoice invoice = null;
		invoice = invoiceMapper.save(invoice);
		ticketService.saveInvoiceTickets(invoice.getId(), invoiceDto.getTickets());
		return invoice;
	}

}
