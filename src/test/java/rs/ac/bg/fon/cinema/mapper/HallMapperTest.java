package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Hall;


@Slf4j
class HallMapperTest extends BaseMapperTest {

	@Autowired
	private HallMapper hallMapper;

	@Test
	void testCRUD() {

		log.info("Adding a new hall");
		Hall hall = Hall.builder().name("Kings Hall").build();
		assertEquals(1, hallMapper.insert(hall));
		
		log.info("Getting hall");
		Hall hallDb = hallMapper.getById(hall.getId());
		assertEquals(hall.getId(), hallDb.getId());
		assertEquals(hall.getName(), hallDb.getName());
		
		log.info("Updating hall");
		hall.setName("Tron hall");
		assertEquals(1, hallMapper.update(hall));
		
		log.info("Getting hall");
		hallDb = hallMapper.getById(hall.getId());
		assertEquals(hall.getId(), hallDb.getId());
		assertEquals(hall.getName(), hallDb.getName());
		
		log.info("Deleting hall");
		assertEquals(1, hallMapper.deleteById(hall.getId()));
		
	}
	

}
