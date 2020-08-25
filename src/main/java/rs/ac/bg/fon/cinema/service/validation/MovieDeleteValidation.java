package rs.ac.bg.fon.cinema.service.validation;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.service.validation.filter.MovieDeleteHasBeenUsed;

@Component
public class MovieDeleteValidation implements Validation<Movie> {

	private MovieDeleteHasBeenUsed hasBeenUsed;
	
	public MovieDeleteValidation(MovieDeleteHasBeenUsed hasBeenUsed) {
		this.hasBeenUsed = hasBeenUsed;
	}
	@Override
	public void validate(Movie t) {
		hasBeenUsed.doFilter(t);
		
	}

}
