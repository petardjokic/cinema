package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.SeatType;

@Slf4j
class SeatTypeMapperTest extends BaseMapperTest{

	@Autowired
	private SeatTypeMapper seatTypeMapper;

	@Test
	void testCRUD() {

		log.info("Adding a new seat type");
		SeatType seatType = SeatType.builder().name("Classic").build();
		assertEquals(1, seatTypeMapper.insert(seatType));
		
		log.info("Getting seat type");
		SeatType seatTypeDb = seatTypeMapper.getById(seatType.getId());
		assertEquals(seatType.getId(), seatTypeDb.getId());
		assertEquals(seatType.getName(), seatTypeDb.getName());
		
		log.info("Updating seat type");
		seatType.setName("vip");
		assertEquals(1, seatTypeMapper.update(seatType));
		
		log.info("Getting seat type");
		seatTypeDb = seatTypeMapper.getById(seatType.getId());
		assertEquals(seatType.getId(), seatTypeDb.getId());
		assertEquals(seatType.getName(), seatTypeDb.getName());
		
		log.info("Deleting seat type");
		assertEquals(1, seatTypeMapper.deleteById(seatType.getId()));
		
	}

}
