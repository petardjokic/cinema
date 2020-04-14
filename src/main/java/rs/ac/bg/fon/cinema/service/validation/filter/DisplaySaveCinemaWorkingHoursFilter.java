package rs.ac.bg.fon.cinema.service.validation.filter;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.exception.ServiceException;
import rs.ac.bg.fon.cinema.service.MovieService;

@Component
public class DisplaySaveCinemaWorkingHoursFilter extends ValidationFilter<Display> {
	
	private LocalTime opens = LocalTime.of(11, 0);
	private LocalTime closes = LocalTime.of(23, 0);
	
	@Autowired
	private MovieService movieService;

	@Override
	protected void action(Display display) {
		LocalTime startsAt = display.getStartsAt().toLocalTime();
		int movieDuration = movieService.getMovieById(display.getMovie().getId()).getDuration();
		LocalTime endsAt = startsAt.plusMinutes(movieDuration);
		if (startsAt.isAfter(closes) || startsAt.isBefore(opens))
			throw new ServiceException(
					String.format("Cannot organize display in non-working hours! Worktime: %s - %s", opens, closes));
		
		if (endsAt.isAfter(closes) || endsAt.isBefore(opens))
			throw new ServiceException(
					String.format("Movie would end after worktime! Should start at least at %s", closes.minusMinutes(movieDuration)));

	}

}
