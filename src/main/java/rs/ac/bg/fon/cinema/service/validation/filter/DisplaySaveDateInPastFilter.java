package rs.ac.bg.fon.cinema.service.validation.filter;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.exception.ServiceException;

@Component
@Slf4j
public class DisplaySaveDateInPastFilter extends ValidationFilter<Display>{

	@Override
	protected void action(Display display) {
		log.info(display.getStartsAt().toString());
		log.info(LocalDateTime.now().toString());
		if(display.getStartsAt().isBefore(LocalDateTime.now())) 
			throw new ServiceException("Cannot organize display in past");
	}

}
