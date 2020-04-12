package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Genre;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.MovieGenre;
import rs.ac.bg.fon.cinema.mapper.setup.GenreSetup;
import rs.ac.bg.fon.cinema.mapper.setup.MovieSetup;

@Slf4j
class MovieGenreMapperTest extends BaseMapperTest {
	
	@Autowired
	private MovieGenreMapper movieGenreMapper;

	@Autowired
	private MovieSetup movieSetup;
	
	@Autowired
	private GenreSetup genreSetup;
	
	@Test
	void testCRUD() {

		Genre genre1 = genreSetup.genreAction();
		Genre genre2 = genreSetup.genreComedy();
		
		Movie movie1 = movieSetup.movieBasicInstinct();
		Movie movie2 = movieSetup.moviePulpFiction();
		
		log.info("Adding a new movie genre");
		MovieGenre movieGenre = MovieGenre.builder().movieId(movie1.getId()).genreId(genre1.getId()).build();
		assertEquals(1, movieGenreMapper.insert(movieGenre));
		
		log.info("Getting movie genre");
		MovieGenre movieGenreDb = movieGenreMapper.getById(movieGenre.getId());
		assertEquals(movieGenre.getId(), movieGenreDb.getId());
		assertEquals(movieGenre.getMovieId(), movieGenreDb.getMovieId());
		assertEquals(movieGenre.getGenreId(), movieGenreDb.getGenreId());
		
		log.info("Updating movie genre");
		movieGenre.setMovieId(movie2.getId());
		movieGenre.setGenreId(genre2.getId());
		assertEquals(1, movieGenreMapper.update(movieGenre));
		
		log.info("Getting movie genre");
		movieGenreDb = movieGenreMapper.getById(movieGenre.getId());
		assertEquals(movieGenre.getId(), movieGenreDb.getId());
		assertEquals(movieGenre.getMovieId(), movieGenreDb.getMovieId());
		assertEquals(movieGenre.getGenreId(), movieGenreDb.getGenreId());
		
		log.info("Deleting movie genre");
		assertEquals(1, movieGenreMapper.deleteById(movieGenre.getId()));
		
	}
	
	@Test
	public void testDeleteMovieGenre() {
		
		Genre genre = genreSetup.genreHorror();
		
		Movie movie = movieSetup.movieTheShawshankRedemption();
				
		log.info("Adding a new movie genre");
		MovieGenre movieGenre = MovieGenre.builder().movieId(movie.getId()).genreId(genre.getId()).build();
		assertEquals(1, movieGenreMapper.insert(movieGenre));
		
		log.info("Deleting genre");
		assertEquals(1, movieGenreMapper.deleteMovieGenre(movieGenre));
	}

}
