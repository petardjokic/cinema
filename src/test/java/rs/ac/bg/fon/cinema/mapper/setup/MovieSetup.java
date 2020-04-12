package rs.ac.bg.fon.cinema.mapper.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.mapper.MovieMapper;

@Component
@Slf4j
public class MovieSetup {

	@Autowired
	private MovieMapper MovieMapper;

	private Movie saveMovie(String title, String trailerUri, String description, int duration, int releaseYear) {
		Movie movie = Movie.builder()
				.title(title)
				.trailerUri(trailerUri)
				.description(description)
				.duration(duration)
				.releaseYear(releaseYear).build();
		MovieMapper.save(movie);
		log.info("Movie {} saved!", movie);
		return movie;
	}

	public Movie movieTheShawshankRedemption() {
		return saveMovie("The Shawshank Redemption", "6hB3S9bIaco", "The Shawshank Redemption desc", 142, 1994);
	}

	public Movie moviePulpFiction() {
		return saveMovie("Pulp Fiction", "s7EdQ4FqbhY", "Pulp Fiction desc", 154, 1994);
	}

	public Movie movieBasicInstinct() {
		return saveMovie("Basic Instinct", "b_20N7t-umo", "Basic Instinct desc", 129, 1992);
	}
}
