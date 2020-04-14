package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.mapper.TicketMapper;
import rs.ac.bg.fon.cinema.service.TicketService;
import rs.ac.bg.fon.cinema.service.dto.TicketSearchRequest;
import rs.ac.bg.fon.cinema.service.dto.TicketSearchResponse;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketMapper ticketMapper;

	@Override
	public Ticket getTicketById(Long ticketId) {
		return ticketMapper.getById(ticketId);
	}

	@Override
	@Transactional
	public void saveInvoiceTickets(Long invoiceId, List<Ticket> tickets) {
		tickets.stream().forEach(ticket -> {
			ticket.setActive(true);
			ticket.setInvoiceId(invoiceId);
			ticketMapper.save(ticket);
		});
	}

	@Override
	public Ticket findActiveByDisplayAndSeat(Ticket ticket) {
		return ticketMapper.findActiveByDisplayAndSeat(ticket);
	}

	@Override
	@Transactional
	public int freezeTicketsByByInvoiceId(Long invoiceId) {
		return ticketMapper.freezeTicketsByInvoiceId(invoiceId);
	}

	@Override
	public TicketSearchResponse searchTickets(TicketSearchRequest request) {
		List<Ticket> tickets = ticketMapper.searchTickets(request);
		return new TicketSearchResponse(tickets);
	}


}
