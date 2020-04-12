package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.domain.Ticket;

public interface TicketService {

	public Ticket getTicketById(Long ticketId);
	
	public List<Ticket> getTicketByDisplayId(Long displayId);
	
	public List<Ticket> getTicketByInvoiceId(Long invoiceId);

	public void saveInvoiceTickets(Long invoiceId, List<Ticket> tickets);

	public Ticket findActiveByDisplayAndSeat(Ticket ticket);

	public int freezeTicketsByByInvoiceId(Long invoiceId);
}
