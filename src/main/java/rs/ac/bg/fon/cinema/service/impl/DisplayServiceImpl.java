package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.DisplayPrice;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.mapper.DisplayMapper;
import rs.ac.bg.fon.cinema.service.DisplayPriceService;
import rs.ac.bg.fon.cinema.service.DisplayService;
import rs.ac.bg.fon.cinema.service.MovieService;
import rs.ac.bg.fon.cinema.service.TicketService;

@Service
public class DisplayServiceImpl implements DisplayService {

	@Autowired
	private DisplayMapper displayMapper;

	@Autowired
	private MovieService movieService;

	@Autowired
	private DisplayPriceService displayPriceService;
	
	@Autowired
	private TicketService ticketService;

	@Override
	public Display getDisplayById(Long displayId) {
		Display display = displayMapper.getById(displayId);
		List<DisplayPrice> prices = displayPriceService.getByDisplayId(displayId);
		display.setPrices(prices);
		List<Ticket> tickets = ticketService.getTicketByDisplayId(displayId);
		display.setTickets(tickets);
		return display;
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
