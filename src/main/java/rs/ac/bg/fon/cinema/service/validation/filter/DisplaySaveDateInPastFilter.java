package rs.ac.bg.fon.cinema.service.validation.filter;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.exception.ServiceException;

@Component
public class DisplaySaveDateInPastFilter extends ValidationFilter<Display>{

	@Override
	protected void action(Display display) {
		if(display.getStartsAt().isBefore(LocalDateTime.now())) 
			throw new ServiceException("Cannot organize display in past");
	}

}
