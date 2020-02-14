package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.mapper.TicketMapper;
import rs.ac.bg.fon.cinema.service.TicketService;
import rs.ac.bg.fon.cinema.service.dto.TicketDto;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketMapper ticketMapper;

	@Override
	public Ticket getTicketById(Long ticketId) {
		return ticketMapper.getById(ticketId);
	}

	@Override
	public List<Ticket> getTicketByDisplayId(Long displayId) {
		return ticketMapper.getByDisplayId(displayId);
	}

	@Override
	public List<TicketDto> getTicketByInvoiceId(Long invoiceId) {
		return ticketMapper.getByInvoiceId(invoiceId);
	}

}
