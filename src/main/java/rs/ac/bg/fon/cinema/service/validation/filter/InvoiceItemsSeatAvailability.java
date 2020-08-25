package rs.ac.bg.fon.cinema.service.validation.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.domain.Seat;
import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.exception.ServiceException;
import rs.ac.bg.fon.cinema.service.TicketService;
import rs.ac.bg.fon.cinema.service.dto.TicketSearchRequest;

@Component
public class InvoiceItemsSeatAvailability extends ValidationFilter<Invoice> {

	@Autowired
	private TicketService ticketService;

	@Override
	protected void action(Invoice entity) {
		Map<Long, List<Seat>> displaySeats = new HashMap<>();

		entity.getItems().stream().forEach(item -> {
			if (displaySeats.get(item.getDisplayId()) == null)
				displaySeats.put(item.getDisplayId(), new ArrayList<Seat>());
			displaySeats.get(item.getDisplayId()).add(item.getSeat());
		});

		displaySeats.forEach((displayId, seatList) -> {
			List<Ticket> tickets = ticketService.searchTickets(TicketSearchRequest.builder().displayId(displayId).active(true).build()).getTickets();
			seatList.forEach(iteamSeat -> {
				boolean ret = false;
				ret = tickets.stream().map(ticket -> ticket.getSeat()).anyMatch(ticketSeat -> ticketSeat.getId().equals(iteamSeat.getId()));
				if(ret)
					throw new ServiceException("Some of items are no longer available");
			});
		});
	}

}
