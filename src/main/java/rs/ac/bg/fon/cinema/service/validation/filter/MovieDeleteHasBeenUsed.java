package rs.ac.bg.fon.cinema.service.validation.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.exception.ServiceException;
import rs.ac.bg.fon.cinema.service.DisplayService;
import rs.ac.bg.fon.cinema.service.dto.DisplaySearchRequest;

@Component
public class MovieDeleteHasBeenUsed extends ValidationFilter<Movie> {
	@Autowired
	private DisplayService displayService;

	@Override
	protected void action(Movie entity) {
		DisplaySearchRequest request = DisplaySearchRequest.builder().movieId(entity.getId()).build();
		List<Display> list = displayService.searchDisplays(request);
		if(!list.isEmpty())
			throw new ServiceException("Cannot delete movie if already used in some projection.");

	}

}
