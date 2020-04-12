package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.DisplayCategory;
import rs.ac.bg.fon.cinema.domain.Hall;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.mapper.setup.DisplayCategorySetup;
import rs.ac.bg.fon.cinema.mapper.setup.HallSetup;
import rs.ac.bg.fon.cinema.mapper.setup.MovieSetup;

@Slf4j
class DisplayMapperTest extends BaseMapperTest{

	@Autowired
	private DisplayMapper displayMapper;

	@Autowired
	private MovieSetup movieSetup;
	
	@Autowired
	private HallSetup hallSetup;
	
	@Autowired
	private DisplayCategorySetup displayCategorySetup;
	
	@Test
	void testCRUD() {
		
		Movie movie1 = movieSetup.movieBasicInstinct();
		Movie movie2 = movieSetup.moviePulpFiction();

		Hall hall1 = hallSetup.hallHallOfLegends();
		Hall hall2 = hallSetup.hallShadowValey();
		
		DisplayCategory category1 = displayCategorySetup.displayCategoryPremiere();
		DisplayCategory category2 =displayCategorySetup.displayCategoryPremiereBlockbuster();
		
		log.info("Adding a new display");
		LocalDateTime startsAt =LocalDateTime.now();
		Display display = Display.builder().movie(movie1).hall(hall1).category(category1).startsAt(startsAt).build();
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
		assertEquals(display.getCategory().getId(), displayDb.getCategory().getId());
		assertEquals(display.getCategory().getName(), displayDb.getCategory().getName());
		assertEquals(display.getStartsAt(), displayDb.getStartsAt());
		
		log.info("Updating display");
		display.setMovie(movie2);
		display.setHall(hall2);
		display.setCategory(category2);
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
		assertEquals(display.getCategory().getId(), displayDb.getCategory().getId());
		assertEquals(display.getCategory().getName(), displayDb.getCategory().getName());
		assertEquals(display.getStartsAt(), displayDb.getStartsAt());
		
		log.info("Deleting display");
		assertEquals(1, displayMapper.deleteById(display.getId()));

	}
}
