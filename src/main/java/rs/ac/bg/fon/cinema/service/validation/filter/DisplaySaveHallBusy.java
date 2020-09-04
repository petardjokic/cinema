package rs.ac.bg.fon.cinema.service.validation.filter;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.exception.ServiceException;
import rs.ac.bg.fon.cinema.service.DisplayService;
import rs.ac.bg.fon.cinema.service.MovieService;
import rs.ac.bg.fon.cinema.service.dto.DisplaySearchRequest;

@Component
public class DisplaySaveHallBusy extends ValidationFilter<Display> {
	@Autowired
	private DisplayService displayService;

	@Autowired
	private MovieService movieService;

	@Override
	protected void action(Display entity) {
		
		Movie movieDisplay = movieService.getMovieById(entity.getMovie().getId());
		
		LocalDateTime startsAtCheck = entity.getStartsAt();
		LocalDateTime endsAtCheck = entity.getStartsAt().plusMinutes(movieDisplay.getDuration());
		
		List<Display> list = displayService
				.searchDisplays(DisplaySearchRequest.builder().hallId(entity.getHall().getId()).build());
		//(StartA <= EndB) and (EndA >= StartB)
		list.forEach(display -> {
			LocalDateTime startsAt = display.getStartsAt();
			LocalDateTime endsAt = display.getStartsAt().plusMinutes(display.getMovie().getDuration());
			if(startsAtCheck.isBefore(endsAt) && endsAtCheck.isAfter(startsAt))
				throw new ServiceException("Hall is busy at selected time!");
		});
	}

}
