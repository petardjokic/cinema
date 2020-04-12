package rs.ac.bg.fon.cinema.service.validation.filter;

import java.time.temporal.ChronoField;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.exception.ServiceException;

@Component
public class DisplaySaveCinemaWorkingDaysFilter extends ValidationFilter<Display> {

	int weekDayOff = 7;

	@Override
	protected void action(Display display) {
		if (display.getStartsAt().get(ChronoField.DAY_OF_WEEK) == weekDayOff)
			throw new ServiceException("Cannot organize display on week off day.");
	}

}
