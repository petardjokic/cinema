package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.Hall;
import rs.ac.bg.fon.cinema.domain.Movie;

@Slf4j
class DisplayMapperTest extends BaseMapperTest{

	@Autowired
	private DisplayMapper displayMapper;

	@Autowired
	private MovieMapper movieMapper;
	
	@Autowired
	private HallMapper hallMapper;
	
	@Test
	void testCRUD() {

		log.info("Adding a new hall 1");
		Hall hall = Hall.builder().name("Kings Hall").build();
		hallMapper.insert(hall);
		
		log.info("Adding a new hall 2");
		Hall hall2 = Hall.builder().name("Lion Hall").build();
		hallMapper.insert(hall2);
		
		log.info("Adding a new movie 1");
		Movie movie = Movie.builder().title("Trainspotting").trailerUri("dsadas").description("Desc").duration(134).releaseYear(1996).build();
		movieMapper.insert(movie);
		
		log.info("Adding a new movie 2");
		Movie movie2 = Movie.builder().title("Trainspotting2").trailerUri("hgj").description("Desc2").duration(1341).releaseYear(11996).build();
		movieMapper.insert(movie2);
		
		log.info("Adding a new display");
		LocalDateTime startsAt =LocalDateTime.now();
		Display display = Display.builder().movie(movie).hall(hall).startsAt(startsAt).build();
		assertEquals(1, displayMapper.insert(display));
		
		log.info("Getting display");
		Display displayDb = displayMapper.getById(display.getId());
		assertEquals(display.getId(), displayDb.getId());
		assertEquals(display.getMovie().getId(), displayDb.getMovie().getId());
		assertEquals(display.getMovie().getTitle(), displayDb.getMovie().getTitle());
		assertEquals(display.getMovie().getTrailerUri(), displayDb.getMovie().getTrailerUri());
		assertEquals(display.getMovie().getDescription(), displayDb.getMovie().getDescription());
		assertEquals(display.getMovie().getDuration(), displayDb.getMovie().getDuration());
		assertEquals(display.getMovie().getReleaseYear(), displayDb.getMovie().getReleaseYear());
		assertEquals(display.getHall().getId(), displayDb.getHall().getId());
		assertEquals(display.getHall().getName(), displayDb.getHall().getName());
		assertEquals(display.getStartsAt(), displayDb.getStartsAt());
		
		log.info("Updating display");
		display.setMovie(movie2);
		display.setHall(hall2);
		assertEquals(1, displayMapper.update(display));
		
		log.info("Getting display");
		displayDb = displayMapper.getById(display.getId());
		assertEquals(display.getId(), displayDb.getId());
		assertEquals(display.getMovie().getId(), displayDb.getMovie().getId());
		assertEquals(display.getMovie().getTitle(), displayDb.getMovie().getTitle());
		assertEquals(display.getMovie().getTrailerUri(), displayDb.getMovie().getTrailerUri());
		assertEquals(display.getMovie().getDescription(), displayDb.getMovie().getDescription());
		assertEquals(display.getMovie().getDuration(), displayDb.getMovie().getDuration());
		assertEquals(display.getMovie().getReleaseYear(), displayDb.getMovie().getReleaseYear());
		assertEquals(display.getHall().getId(), displayDb.getHall().getId());
		assertEquals(display.getHall().getName(), displayDb.getHall().getName());
		assertEquals(display.getStartsAt(), displayDb.getStartsAt());
		
		log.info("Deleting display");
		assertEquals(1, displayMapper.deleteById(display.getId()));

	}
}
