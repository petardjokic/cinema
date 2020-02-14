package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.mapper.InvoiceMapper;
import rs.ac.bg.fon.cinema.service.DisplayService;
import rs.ac.bg.fon.cinema.service.InvoiceService;
import rs.ac.bg.fon.cinema.service.TicketService;
import rs.ac.bg.fon.cinema.service.dto.InvoiceDto;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceMapper invoiceMapper;
	
	@Autowired 
	private TicketService ticketService;
	
	@Autowired
	private DisplayService displayService;
	
	@Override
	public InvoiceDto getInvoiceById(Long invoiceId) {
		Invoice invoice = invoiceMapper.getById(invoiceId);
		return null;
	}

}
