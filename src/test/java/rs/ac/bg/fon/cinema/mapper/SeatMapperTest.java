package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Hall;
import rs.ac.bg.fon.cinema.domain.Seat;
import rs.ac.bg.fon.cinema.domain.SeatType;

@Slf4j
class SeatMapperTest extends BaseMapperTest{
	
	@Autowired
	private SeatMapper seatMapper;
	
	@Autowired
	private HallMapper hallMapper;
	
	@Autowired
	private SeatTypeMapper seatTypeMapper;

	@Test
	void testCRUD() {
		
		log.info("Adding a new hall");
		Hall hall = Hall.builder().name("Kings Hall").build();
		hallMapper.insert(hall);
		
		log.info("Adding a new seat type 1");
		SeatType seatType1 = SeatType.builder().name("Classic").build();
		seatTypeMapper.insert(seatType1);
		
		log.info("Adding a new seat type 2");
		SeatType seatType2 = SeatType.builder().name("VIP").build();
		seatTypeMapper.insert(seatType2);
		
		log.info("Adding a new seat");
		Seat seat = Seat.builder().hallId(hall.getId()).type(seatType1).row(1).column(1).build();
		assertEquals(1, seatMapper.insert(seat));
		
		log.info("Getting seat");
		Seat seatDb = seatMapper.getById(seat.getId());
		assertEquals(seat.getId(), seatDb.getId());
		assertEquals(seat.getHallId(), seatDb.getHallId());
		assertEquals(seat.getType().getId(), seatDb.getType().getId());
		assertEquals(seat.getType().getName(), seatDb.getType().getName());
		assertEquals(seat.getRow(), seatDb.getRow());
		assertEquals(seat.getColumn(), seatDb.getColumn());
		
		log.info("Updating seat");
		seat.setType(seatType2);
		seat.setRow(2);
		seat.setColumn(2);
		assertEquals(1, seatMapper.update(seat));
		
		log.info("Getting seat");
		seatDb = seatMapper.getById(seat.getId());
		assertEquals(seat.getId(), seatDb.getId());
		assertEquals(seat.getHallId(), seatDb.getHallId());
		assertEquals(seat.getType().getId(), seatDb.getType().getId());
		assertEquals(seat.getType().getName(), seatDb.getType().getName());
		assertEquals(seat.getRow(), seatDb.getRow());
		assertEquals(seat.getColumn(), seatDb.getColumn());
		
		log.info("Deleting seat");
		assertEquals(1, seatMapper.deleteById(seat.getId()));
		
	}

}
