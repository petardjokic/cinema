package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.DisplayPrice;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.Seat;
import rs.ac.bg.fon.cinema.domain.SeatAvailability;
import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.mapper.DisplayMapper;
import rs.ac.bg.fon.cinema.service.DisplayPriceService;
import rs.ac.bg.fon.cinema.service.DisplayService;
import rs.ac.bg.fon.cinema.service.HallService;
import rs.ac.bg.fon.cinema.service.MovieService;
import rs.ac.bg.fon.cinema.service.TicketService;

@Service
public class DisplayServiceImpl implements DisplayService {

	@Autowired
	private DisplayMapper displayMapper;

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private HallService hallService;

	@Autowired
	private DisplayPriceService displayPriceService;
	
	@Autowired
	private TicketService ticketService;

	@Override
	public Display getDisplayById(Long displayId) {
		Display display = displayMapper.getById(displayId);
		Movie movie = movieService.getMovieById(display.getMovie().getId());
		display.setMovie(movie);
		List<DisplayPrice> prices = displayPriceService.getByDisplayId(displayId);
		display.setPrices(prices);
		List<Ticket> tickets = ticketService.getTicketByDisplayId(displayId);
		display.setTickets(tickets);
		computeSeatsAvailability(display);
		return display;
	}

	private void computeSeatsAvailability(Display display) {
		List<Seat> hallSeats = hallService.getSeatsByHallId(display.getHall().getId());
		List<SeatAvailability> seatsAvailability = hallSeats.stream()
				.map(seat -> SeatAvailability.builder().seat(seat).free(true).build())
				.collect(Collectors.toList());
		
		display.getTickets().forEach(ticket -> {
			seatsAvailability.stream()
					.filter(seatAvailability -> ticket.getSeat().getId().equals(seatAvailability.getSeat().getId()))
					.findFirst()
					.ifPresent(seatAvailability -> seatAvailability.setFree(false));
		});
		
		display.setSeatsAvailability(seatsAvailability);
	}

	@Override
	public List<Display> getAllDisplays() {
		List<Display> displays = displayMapper.getAll();
		return displays;
	}

	@Override
	@Transactional
	public Display saveDisplay(Display displayDto) {
		Movie movieDb = movieService.getMovieById(displayDto.getMovie().getId());
		Display display = Display.builder().id(displayDto.getId()).movie(null)
				.hall(null).startsAt(displayDto.getStartsAt()).build();
		displayMapper.save(display);
		displayPriceService.saveDisplayPriceForDisplay(display.getId(), displayDto.getPrices());
		return display;
	}

	@Override
	public int deleteDisplayById(Long displayId) {
		return displayMapper.deleteById(displayId);
	}

}
