package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Genre;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.MovieGenre;

@Slf4j
class MovieGenreMapperTest extends BaseMapperTest {
	
	@Autowired
	private MovieGenreMapper movieGenreMapper;

	@Autowired
	private MovieMapper movieMapper;
	
	@Autowired
	private GenreMapper genreMapper;
	
	@Test
	void testCRUD() {
		assertEquals(0L, movieGenreMapper.count());

		log.info("Adding a new genre 1");
		Genre genre = Genre.builder().name("KGenre").build();
		genreMapper.insert(genre);
		
		log.info("Adding a new genre 2");
		Genre genre2 = Genre.builder().name("KGenre2").build();
		genreMapper.insert(genre2);
		
		log.info("Adding a new movie 1");
		Movie movie = Movie.builder().title("Trainspotting").description("Desc").duration(134).releaseYear(1996).build();
		movieMapper.insert(movie);
		
		log.info("Adding a new movie 2");
		Movie movie2 = Movie.builder().title("Trainspotting2").description("Desc2").duration(1341).releaseYear(11996).build();
		movieMapper.insert(movie2);
		
		log.info("Adding a new movie genre");
		MovieGenre movieGenre = MovieGenre.builder().movieId(movie.getId()).genreId(genre.getId()).build();
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
		
		log.info("Deleting genre");
		assertEquals(1, movieGenreMapper.deleteById(movieGenre.getId()));
		
		assertEquals(0, movieGenreMapper.count());

	}

}
