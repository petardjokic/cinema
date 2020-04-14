package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.service.dto.TicketSearchRequest;
import rs.ac.bg.fon.cinema.service.dto.TicketSearchResponse;

public interface TicketService {

	public Ticket getTicketById(Long ticketId);

	public void saveInvoiceTickets(Long invoiceId, List<Ticket> tickets);

	public Ticket findActiveByDisplayAndSeat(Ticket ticket);

	public int freezeTicketsByByInvoiceId(Long invoiceId);

	public TicketSearchResponse searchTickets(TicketSearchRequest request);
}
