package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.service.dto.TicketDto;

public interface TicketService {

	public Ticket getTicketById(Long ticketId);
	
	public List<TicketDto> getTicketByDisplayId(Long displayId);
	
	public List<TicketDto> getTicketByInvoiceId(Long invoiceId);

	public void saveInvoiceTickets(Long invoiceId, List<TicketDto> tickets);
}
