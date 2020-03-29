package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.Hall;
import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.Seat;
import rs.ac.bg.fon.cinema.domain.SeatType;
import rs.ac.bg.fon.cinema.domain.Ticket;

@Slf4j
class TicketMapperTest extends BaseMapperTest{
	
	@Autowired
	private TicketMapper ticketMapper;
	
	@Autowired
	private InvoiceMapper invoiceMapper;
	
	@Autowired
	private DisplayMapper displayMapper;

	@Autowired
	private MovieMapper movieMapper;
	
	@Autowired
	private HallMapper hallMapper;
	
	@Autowired
	private SeatMapper hallSeatMapper;
	
	@Autowired
	private SeatTypeMapper seatTypeMapper;
	
	@Test
	void testCRUD() {
		
		log.info("Adding a new hall");
		Hall hall = Hall.builder().name("Kings Hall").build();
		hallMapper.insert(hall);
		
		log.info("Adding a new seat type");
		SeatType seatType1 = SeatType.builder().name("Classic").build();
		seatTypeMapper.insert(seatType1);
		
		log.info("Adding a new hall seat");
		Seat hallseat = Seat.builder().hallId(hall.getId()).type(seatType1).row(1).column(1).build();
		hallSeatMapper.insert(hallseat);
		
		log.info("Adding a new movie");
		Movie movie = Movie.builder().title("Trainspotting").trailerUri("das").description("Desc").duration(134).releaseYear(1996).build();
		movieMapper.insert(movie);
		
		log.info("Adding a new display");
		LocalDateTime startsAt =LocalDateTime.now();
		Display display = Display.builder().movie(movie).hall(hall).startsAt(startsAt).build();
		displayMapper.insert(display);
		
		log.info("Adding a new invoice");
		Invoice invoice = Invoice.builder().issuedAt(LocalDateTime.now()).active(new Boolean(true)).build();
		invoiceMapper.insert(invoice);
		
		log.info("Adding a new ticket");
		Ticket ticket = Ticket.builder().invoiceId(invoice.getId()).displayId(display.getId()).seat(hallseat).active(new Boolean(true)).build();
		assertEquals(1,ticketMapper.insert(ticket));
		
		log.info("Getting ticket");
		Ticket ticketDb = ticketMapper.getById(ticket.getId());
		assertEquals(ticket.getId(), ticketDb.getId());
		assertEquals(ticket.getDisplayId(), ticketDb.getDisplayId());
		assertEquals(ticket.getInvoiceId(), ticketDb.getInvoiceId());
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
		assertEquals(ticket.getInvoiceId(), ticketDb.getInvoiceId());
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
