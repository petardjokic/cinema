package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Genre;

@Slf4j
class GenreMapperTest extends BaseMapperTest{

	@Autowired
	private GenreMapper genreMapper;

	@Test
	void testCRUD() {

		log.info("Adding a new genre");
		Genre genre = Genre.builder().name("KGenre").build();
		assertEquals(1, genreMapper.insert(genre));
		
		log.info("Getting genre");
		Genre genreDb = genreMapper.getById(genre.getId());
		assertEquals(genre.getId(), genreDb.getId());
		assertEquals(genre.getName(), genreDb.getName());
		
		log.info("Updating genre");
		genre.setName("Genre");
		assertEquals(1, genreMapper.update(genre));
		
		log.info("Getting genre");
		genreDb = genreMapper.getById(genre.getId());
		assertEquals(genre.getId(), genreDb.getId());
		assertEquals(genre.getName(), genreDb.getName());
		
		log.info("Deleting genre");
		assertEquals(1, genreMapper.deleteById(genre.getId()));
		
	}

}
