package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.Hall;
import rs.ac.bg.fon.cinema.domain.HallSeat;
import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.SeatType;
import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.service.dto.TicketDto;

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
	private HallSeatMapper hallSeatMapper;
	
	@Autowired
	private SeatTypeMapper seatTypeMapper;
	
	@Test
	void testCRUD() {
		
		assertEquals(0, ticketMapper.count());

		log.info("Adding a new hall");
		Hall hall = Hall.builder().name("Kings Hall").build();
		hallMapper.insert(hall);
		
		log.info("Adding a new seat type");
		SeatType seatType1 = SeatType.builder().name("Classic").build();
		seatTypeMapper.insert(seatType1);
		
		log.info("Adding a new hall seat");
		HallSeat hallseat = HallSeat.builder().hallId(hall.getId()).seatTypeId(seatType1.getId()).row(1).column(1).build();
		hallSeatMapper.insert(hallseat);
		
		log.info("Adding a new movie");
		Movie movie = Movie.builder().title("Trainspotting").description("Desc").duration(134).releaseYear(1996).build();
		movieMapper.insert(movie);
		
		log.info("Adding a new display");
		LocalDateTime startsAt =LocalDateTime.now();
		Display display = Display.builder().movieId(movie.getId()).hallId(hall.getId()).startsAt(startsAt).endsAt(startsAt.plusMinutes(movie.getDuration())).build();
		displayMapper.insert(display);
		
		log.info("Adding a new invoice");
		Invoice invoice = Invoice.builder().issuedAt(LocalDateTime.now()).active(new Boolean(true)).build();
		invoiceMapper.insert(invoice);
		
		log.info("Adding a new ticket");
		Ticket ticket = Ticket.builder().invoiceId(invoice.getId()).displayId(display.getId()).seatId(hallseat.getId()).build();
		assertEquals(1,ticketMapper.insert(ticket));
		
		log.info("Getting ticket");
		Ticket ticketDb = ticketMapper.getById(ticket.getId());
		assertEquals(ticket.getId(), ticketDb.getId());
		assertEquals(ticket.getDisplayId(), ticketDb.getDisplayId());
		assertEquals(ticket.getSeatId(), ticketDb.getSeatId());
		
		log.info("Updating ticket");
		assertEquals(1, ticketMapper.update(ticket));
		
		log.info("Getting ticket");
		ticketDb = ticketMapper.getById(ticket.getId());
		assertEquals(ticket.getId(), ticketDb.getId());
		assertEquals(ticket.getDisplayId(), ticketDb.getDisplayId());
		assertEquals(ticket.getSeatId(), ticketDb.getSeatId());
		
		log.info("Deleting ticket");
		assertEquals(1, ticketMapper.deleteById(ticket.getId()));
		
		assertEquals(0, ticketMapper.count());
	}
	
	@Test
	void testReturnTicketDto() {
		log.info("Adding a new hall");
		Hall hall = Hall.builder().name("Kings Hall").build();
		hallMapper.insert(hall);
		
		log.info("Adding a new seat type");
		SeatType seatType1 = SeatType.builder().name("Classic").build();
		seatTypeMapper.insert(seatType1);
		
		log.info("Adding a new hall seat");
		HallSeat hallseat = HallSeat.builder().hallId(hall.getId()).seatTypeId(seatType1.getId()).row(1).column(1).build();
		hallSeatMapper.insert(hallseat);
		
		log.info("Adding a new movie");
		Movie movie = Movie.builder().title("Trainspotting").description("Desc").duration(134).releaseYear(1996).build();
		movieMapper.insert(movie);
		
		log.info("Adding a new display");
		LocalDateTime startsAt =LocalDateTime.now();
		Display display = Display.builder().movieId(movie.getId()).hallId(hall.getId()).startsAt(startsAt).endsAt(startsAt.plusMinutes(movie.getDuration())).build();
		displayMapper.insert(display);
		
		log.info("Adding a new invoice");
		Invoice invoice = Invoice.builder().issuedAt(LocalDateTime.now()).active(new Boolean(true)).build();
		invoiceMapper.insert(invoice);
		
		log.info("Adding a new ticket");
		Ticket ticket = Ticket.builder().invoiceId(invoice.getId()).displayId(display.getId()).seatId(hallseat.getId()).build();
		assertEquals(1,ticketMapper.insert(ticket));
		
		log.info("Adding a new ticket");
		Ticket ticket2 = Ticket.builder().invoiceId(invoice.getId()).displayId(display.getId()).seatId(hallseat.getId()).build();
		assertEquals(1,ticketMapper.insert(ticket2));
		
		log.info("Getting ticket");
		List<TicketDto> ticketsDb = ticketMapper.getByInvoiceId(invoice.getId());
		assertEquals(ticket.getId(), ticketsDb.get(0).getTicketId());
		assertEquals(ticket.getDisplayId(), ticketsDb.get(0).getDisplayId());
		assertEquals(display.getStartsAt(), ticketsDb.get(0).getStartsAt());
		assertEquals(movie.getTitle(), ticketsDb.get(0).getMovie().getTitle());
		assertEquals(hall.getName(), ticketsDb.get(0).getHall().getName());
		assertEquals(hallseat.getRow(), ticketsDb.get(0).getSeat().getRow());
		assertEquals(hallseat.getColumn(), ticketsDb.get(0).getSeat().getColumn());
		assertEquals(seatType1.getId(), ticketsDb.get(0).getSeat().getSeatType().getId());
		assertEquals(seatType1.getName(), ticketsDb.get(0).getSeat().getSeatType().getName());
	}
	

}
