package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Hall;
import rs.ac.bg.fon.cinema.domain.HallSeat;
import rs.ac.bg.fon.cinema.domain.SeatType;

@Slf4j
class HallSeatMapperTest extends BaseMapperTest{
	
	@Autowired
	private HallSeatMapper hallSeatMapper;
	
	@Autowired
	private HallMapper hallMapper;
	
	@Autowired
	private SeatTypeMapper seatTypeMapper;

	@Test
	void testCRUD() {
		assertEquals(0L, hallSeatMapper.count());
		
		log.info("Adding a new hall");
		Hall hall = Hall.builder().name("Kings Hall").build();
		hallMapper.insert(hall);
		
		log.info("Adding a new seat type 1");
		SeatType seatType1 = SeatType.builder().name("Classic").build();
		seatTypeMapper.insert(seatType1);
		
		log.info("Adding a new seat type 2");
		SeatType seatType2 = SeatType.builder().name("VIP").build();
		seatTypeMapper.insert(seatType2);
		
		log.info("Adding a new hall seat");
		HallSeat hallseat = HallSeat.builder().hallId(hall.getId()).seatTypeId(seatType1.getId()).row(1).column(1).build();
		assertEquals(1, hallSeatMapper.insert(hallseat));
		
		log.info("Getting hall seat");
		HallSeat hallseatDb = hallSeatMapper.getById(hallseat.getId());
		assertEquals(hallseat.getId(), hallseatDb.getId());
		assertEquals(hallseat.getHallId(), hallseatDb.getHallId());
		assertEquals(hallseat.getSeatTypeId(), hallseatDb.getSeatTypeId());
		assertEquals(hallseat.getRow(), hallseatDb.getRow());
		assertEquals(hallseat.getColumn(), hallseatDb.getColumn());
		
		log.info("Updating hall seat");
		hallseat.setSeatTypeId(seatType2.getId());
		hallseat.setRow(2);
		hallseat.setColumn(2);
		assertEquals(1, hallSeatMapper.update(hallseat));
		
		log.info("Getting hall seat");
		hallseatDb = hallSeatMapper.getById(hallseat.getId());
		assertEquals(hallseat.getId(), hallseatDb.getId());
		assertEquals(hallseat.getHallId(), hallseatDb.getHallId());
		assertEquals(hallseat.getSeatTypeId(), hallseatDb.getSeatTypeId());
		assertEquals(hallseat.getRow(), hallseatDb.getRow());
		assertEquals(hallseat.getColumn(), hallseatDb.getColumn());
		
		log.info("Deleting hall seat");
		assertEquals(1, hallSeatMapper.deleteById(hallseat.getId()));
		
		assertEquals(0, hallSeatMapper.count());

	}

}
