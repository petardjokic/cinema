package rs.ac.bg.fon.cinema.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.mapper.InvoiceMapper;
import rs.ac.bg.fon.cinema.service.InvoiceService;
import rs.ac.bg.fon.cinema.service.TicketService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceMapper invoiceMapper;
	
	@Autowired 
	private TicketService ticketService;
	
	
	@Override
	public Invoice getInvoiceById(Long invoiceId) {
		Invoice invoice = invoiceMapper.getById(invoiceId);
		List<Ticket> tickets = ticketService.getTicketByInvoiceId(invoice.getId());
		invoice.setTickets(tickets);
		return invoice;
	}

	@Override
	@Transactional
	public Invoice saveInvoice(Invoice invoiceDto) {
		Invoice invoice = null;
		invoice= invoiceMapper.save(invoice);
		ticketService.saveInvoiceTickets(invoice.getId(), invoiceDto.getTickets());
		return invoice;
	}

}
