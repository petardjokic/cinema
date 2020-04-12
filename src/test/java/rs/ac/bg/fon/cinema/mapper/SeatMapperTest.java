package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Hall;
import rs.ac.bg.fon.cinema.domain.Seat;
import rs.ac.bg.fon.cinema.domain.SeatType;
import rs.ac.bg.fon.cinema.mapper.setup.HallSetup;
import rs.ac.bg.fon.cinema.mapper.setup.SeatTypeSetup;

@Slf4j
class SeatMapperTest extends BaseMapperTest{
	
	@Autowired
	private SeatMapper seatMapper;
	
	@Autowired
	private HallSetup hallSetup;
	
	@Autowired
	private SeatTypeSetup seatTypeSetup;

	@Test
	void testCRUD() {
		
		Hall hall1 = hallSetup.hallHallOfLegends();
		Hall hall2 = hallSetup.hallShadowValey();
		
		SeatType seatType1 = seatTypeSetup.seatTypeClassic();
		SeatType seatType2 = seatTypeSetup.seatTypeLove();
		
		log.info("Adding a new seat");
		Seat seat = Seat.builder().hallId(hall1.getId()).type(seatType1).row(1).column(1).build();
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
		seat.setHallId(hall2.getId());
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
