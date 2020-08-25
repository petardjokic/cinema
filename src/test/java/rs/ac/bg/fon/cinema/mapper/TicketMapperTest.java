package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.mapper.setup.DisplaySetup;
import rs.ac.bg.fon.cinema.mapper.setup.InvoiceSetup;

@Slf4j
class TicketMapperTest extends BaseMapperTest{
	
	@Autowired
	private TicketMapper ticketMapper;
	
	@Autowired
	private InvoiceSetup invoiceSetup;
	
	@Autowired
	private DisplaySetup displaySetup;
	
	@Test
	void testCRUD() {
		
		Display display = displaySetup.displayThirdWithHallSeat();
		
		Invoice invoice = invoiceSetup.invoiceActive();
		
		log.info("Adding a new ticket");
		Ticket ticket = Ticket.builder()
				.displayId(display.getId())
				.seat(display.getHall().getSeats().get(0))
				.active(new Boolean(true)).build();
		assertEquals(1,ticketMapper.insert(ticket));
		
		log.info("Getting ticket");
		Ticket ticketDb = ticketMapper.getById(ticket.getId());
		assertEquals(ticket.getId(), ticketDb.getId());
		assertEquals(ticket.getDisplayId(), ticketDb.getDisplayId());
		assertEquals(ticket.getActive(), ticketDb.getActive());
		assertEquals(ticket.getSeat().getId(), ticketDb.getSeat().getId());
		assertEquals(ticket.getSeat().getRow(), ticketDb.getSeat().getRow());
		assertEquals(ticket.getSeat().getColumn(), ticketDb.getSeat().getColumn());
		assertEquals(ticket.getSeat().getType().getId(), ticketDb.getSeat().getType().getId());
		assertEquals(ticket.getSeat().getType().getName(), ticketDb.getSeat().getType().getName());
		
		log.info("Updating ticket");
		assertEquals(1, ticketMapper.update(ticket));
		
		log.info("Getting ticket");
		ticketDb = ticketMapper.getById(ticket.getId());
		assertEquals(ticket.getId(), ticketDb.getId());
		assertEquals(ticket.getDisplayId(), ticketDb.getDisplayId());
		assertEquals(ticket.getActive(), ticketDb.getActive());
		assertEquals(ticket.getSeat().getId(), ticketDb.getSeat().getId());
		assertEquals(ticket.getSeat().getRow(), ticketDb.getSeat().getRow());
		assertEquals(ticket.getSeat().getColumn(), ticketDb.getSeat().getColumn());
		assertEquals(ticket.getSeat().getType().getId(), ticketDb.getSeat().getType().getId());
		assertEquals(ticket.getSeat().getType().getName(), ticketDb.getSeat().getType().getName());
		
		log.info("Deleting ticket");
		assertEquals(1, ticketMapper.deleteById(ticket.getId()));
		
	}
	
	

}
