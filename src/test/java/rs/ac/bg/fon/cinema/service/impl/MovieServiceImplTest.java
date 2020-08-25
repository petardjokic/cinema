package rs.ac.bg.fon.cinema.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Genre;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.ProductionCompany;
import rs.ac.bg.fon.cinema.mapper.BaseMapperTest;
import rs.ac.bg.fon.cinema.mapper.setup.GenreSetup;
import rs.ac.bg.fon.cinema.mapper.setup.ProductionCompanySetup;
import rs.ac.bg.fon.cinema.service.MovieService;

@Slf4j
class MovieServiceImplTest extends BaseMapperTest {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private GenreSetup genreSetup;
	
	@Autowired
	private ProductionCompanySetup productionCompanySetup;
	

	@Test
	void saveMovie() {
		Movie movie = Movie.builder()
				.title("Movie 1")
				.trailerUri("asdasdsadas")
				.description("Movie 1 desc")
				.duration(123)
				.releaseYear(2020)
//				.genres(new ArrayList<Genre>(Arrays.asList(
//						genreSetup.genreAction(),
//						genreSetup.genreComedy()
//						)))
//				.productionCompanies(new ArrayList<ProductionCompany>(Arrays.asList(
//						productionCompanySetup.productionCompanyFirstPC(),
//						productionCompanySetup.productionCompanySecondPC()
//						)))
				.build();
		
		log.info("Inserting movie");
		movieService.saveMovie(movie);
		
		Movie movieDb = movieService.getMovieById(movie.getId());
		assertEquals(movie.getId(), movieDb.getId());
		assertEquals(movie.getTitle(), movieDb.getTitle());
		assertEquals(movie.getTrailerUri(), movieDb.getTrailerUri());
		assertEquals(movie.getDescription(), movieDb.getDescription());
		assertEquals(movie.getDuration(), movieDb.getDuration());
		assertEquals(movie.getReleaseYear(), movieDb.getReleaseYear());
		assertEquals(movie.getGenres().size(), movieDb.getGenres().size());
		assertEquals(movie.getProductionCompanies().size(), movieDb.getProductionCompanies().size());
		
		movie.setTitle("Movie 1 upd");
		movie.setTrailerUri("asdasdsadas upd");
		movie.setDescription("Movie 1 desc upd");
		movie.setDuration(124);
		movie.setReleaseYear(2021);
		movie.getGenres().remove(0);
//		movie.getGenres().add(genreSetup.genreHorror());
		movie.getProductionCompanies().remove(0);
//		movie.getProductionCompanies().add(productionCompanySetup.productionCompanyThirdPC());
		
		log.info("Updating movie");
		movieService.saveMovie(movie);
		
		movieDb = movieService.getMovieById(movie.getId());
		assertEquals(movie.getId(), movieDb.getId());
		assertEquals(movie.getTitle(), movieDb.getTitle());
		assertEquals(movie.getTrailerUri(), movieDb.getTrailerUri());
		assertEquals(movie.getDescription(), movieDb.getDescription());
		assertEquals(movie.getDuration(), movieDb.getDuration());
		assertEquals(movie.getReleaseYear(), movieDb.getReleaseYear());
		assertEquals(movie.getGenres().size(), movieDb.getGenres().size());
		assertEquals(movie.getProductionCompanies().size(), movieDb.getProductionCompanies().size());
		
	}

}
