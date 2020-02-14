package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.service.dto.TicketDto;

public interface TicketService {

	public Ticket getTicketById(Long ticketId);
	
	public List<Ticket> getTicketByDisplayId(Long displayId);
	
	public List<TicketDto> getTicketByInvoiceId(Long invoiceId);
}
