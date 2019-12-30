package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Movie;

@Slf4j
class MovieMapperTest extends BaseMapperTest{

	@Autowired
	private MovieMapper movieMapper;

	@Test
	void testCRUD() {
		assertEquals(0L, movieMapper.count());

		log.info("Adding a new movie");
		Movie movie = Movie.builder().title("Trainspotting").description("Desc").duration(134).releaseYear(1996).build();
		assertEquals(1, movieMapper.insert(movie));
		
		log.info("Getting movie");
		Movie movieDb = movieMapper.getById(movie.getId());
		assertEquals(movie.getId(), movieDb.getId());
		assertEquals(movie.getTitle(), movieDb.getTitle());
		assertEquals(movie.getDescription(), movieDb.getDescription());
		assertEquals(movie.getDuration(), movieDb.getDuration());
		assertEquals(movie.getReleaseYear(), movieDb.getReleaseYear());
		
		log.info("Updating movie");
		movie.setTitle("upd");
		movie.setDescription("dessc");
		movie.setDuration(111);
		movie.setDuration(111);
		movie.setReleaseYear(1998);
		assertEquals(1, movieMapper.update(movie));
		
		log.info("Getting movie");
		movieDb = movieMapper.getById(movie.getId());
		assertEquals(movie.getId(), movieDb.getId());
		assertEquals(movie.getTitle(), movieDb.getTitle());
		assertEquals(movie.getDescription(), movieDb.getDescription());
		assertEquals(movie.getDuration(), movieDb.getDuration());
		assertEquals(movie.getReleaseYear(), movieDb.getReleaseYear());
		
		log.info("Deleting movie");
		assertEquals(1, movieMapper.deleteById(movie.getId()));
		
		assertEquals(0, movieMapper.count());

	}

}
