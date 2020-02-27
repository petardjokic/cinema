package rs.ac.bg.fon.cinema.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.DisplayPrice;
import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.mapper.DisplayMapper;
import rs.ac.bg.fon.cinema.service.DisplayPriceService;
import rs.ac.bg.fon.cinema.service.DisplayService;
import rs.ac.bg.fon.cinema.service.HallService;
import rs.ac.bg.fon.cinema.service.MovieService;
import rs.ac.bg.fon.cinema.service.TicketService;
import rs.ac.bg.fon.cinema.service.dto.DisplayDto;
import rs.ac.bg.fon.cinema.service.dto.HallDto;
import rs.ac.bg.fon.cinema.service.dto.MovieDto;
import rs.ac.bg.fon.cinema.service.dto.TicketDto;

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
	public DisplayDto getDisplayById(Long displayId) {
		Display display = displayMapper.getById(displayId);
		DisplayDto displayDto = getDisplayDto(display);
		return displayDto;
	}

	@Override
	public List<DisplayDto> getAllDisplays() {
		List<DisplayDto> displaysDto = new ArrayList<>();
		List<Display> displays = displayMapper.getAll();
		displays.forEach(display -> {
			DisplayDto displayDto = getDisplayDto(display);
			displaysDto.add(displayDto);
		});
		return displaysDto;
	}

	private DisplayDto getDisplayDto(Display display) {
		MovieDto movieDto = movieService.getMovieById(display.getMovieId());
		HallDto hallDto = hallService.getHallById(display.getHallId());
		List<DisplayPrice> displayPrices = displayPriceService.getByDisplayId(display.getId());
		List<TicketDto> ticketsDto = ticketService.getTicketByDisplayId(display.getId());
		return convertDisplayToDto(display, movieDto, hallDto, displayPrices, ticketsDto);
	}

	private DisplayDto convertDisplayToDto(Display display, MovieDto movieDto, HallDto hallDto,
			List<DisplayPrice> displayPrices, List<TicketDto> ticketsDto) {
		return DisplayDto.builder().id(display.getId()).startsAt(display.getStartsAt()).endsAt(display.getEndsAt())
				.movie(movieDto).hall(hallDto).displayPrices(displayPrices).tickets(ticketsDto).build();
	}

	@Override
	@Transactional
	public Display saveDisplay(DisplayDto displayDto) {
		MovieDto movieDb = movieService.getMovieById(displayDto.getMovie().getId());
		LocalDateTime endsAt = displayDto.getStartsAt().plusMinutes(movieDb.getDuration());
		Display display = Display.builder().id(displayDto.getId()).movieId(displayDto.getMovie().getId())
				.hallId(displayDto.getHall().getId()).startsAt(displayDto.getStartsAt()).endsAt(endsAt).build();
		displayMapper.save(display);
		displayPriceService.saveDisplayPriceForDisplay(display.getId(), displayDto.getDisplayPrices());
		return display;
	}

	@Override
	public int deleteDisplayById(Long displayId) {
		return displayMapper.deleteById(displayId);
	}

}
