package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.exception.ServiceException;
import rs.ac.bg.fon.cinema.mapper.DisplayMapper;
import rs.ac.bg.fon.cinema.service.DisplayCategoryService;
import rs.ac.bg.fon.cinema.service.DisplayService;
import rs.ac.bg.fon.cinema.service.HallService;
import rs.ac.bg.fon.cinema.service.MovieService;
import rs.ac.bg.fon.cinema.service.TicketService;
import rs.ac.bg.fon.cinema.service.dto.DisplaySearchRequest;
import rs.ac.bg.fon.cinema.service.dto.TicketSearchRequest;
import rs.ac.bg.fon.cinema.service.dto.TicketSearchResponse;
import rs.ac.bg.fon.cinema.service.validation.DisplaySaveValidation;

@Service
public class DisplayServiceImpl implements DisplayService {

	@Autowired
	private DisplayMapper displayMapper;

	@Autowired
	private MovieService movieService;

	@Autowired
	private HallService hallService;

	@Autowired
	private DisplayCategoryService displayCategoryService;

	@Autowired
	private TicketService ticketService;

	@Autowired
	private DisplaySaveValidation displaySaveValidation;

	@Override
	public Display getDisplayById(Long displayId) {
		Display display = displayMapper.getById(displayId);
		Optional.ofNullable(display).orElseThrow(
				() -> new ServiceException(String.format("Display with ID: %s does not exist!", displayId)));
		display.setMovie(movieService.getMovieById(display.getMovie().getId()));
		display.setHall(hallService.getHallById(display.getHall().getId()));
		display.setCategory(displayCategoryService.getById(display.getCategory().getId()));
		TicketSearchResponse searchResponse = ticketService
				.searchTickets(TicketSearchRequest.builder().displayId(displayId).active(true).build());
		display.setTickets(searchResponse.getTickets());
		return display;
	}

	@Override
	public List<Display> getAllDisplays() {
		List<Display> displays = displayMapper.getAll();
		return displays;
	}

	@Override
	@Transactional
	public Display saveDisplay(Display display) {
		displaySaveValidation.validate(display);
		displayMapper.save(display);
		return getDisplayById(display.getId());
	}

	@Override
	public int deleteDisplayById(Long displayId) {
		return displayMapper.deleteById(displayId);
	}

	@Override
	public int cancelDisplay(Long id) {
		return displayMapper.deactivateDisplay(id);
	}

	@Override
	public List<Display> searchDisplays(DisplaySearchRequest request) {
		return displayMapper.search(request);
	}

}
