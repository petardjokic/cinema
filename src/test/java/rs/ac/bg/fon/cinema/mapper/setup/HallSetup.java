package rs.ac.bg.fon.cinema.mapper.setup;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Hall;
import rs.ac.bg.fon.cinema.domain.Seat;
import rs.ac.bg.fon.cinema.domain.SeatType;
import rs.ac.bg.fon.cinema.mapper.HallMapper;
import rs.ac.bg.fon.cinema.mapper.SeatMapper;

@Component
@Slf4j
public class HallSetup {
	
	@Autowired
	private HallMapper hallMapper;
	
	@Autowired
	private SeatMapper seatMapper;
	
	@Autowired
	private SeatTypeSetup seatTypeSetup;
	
	private Hall saveHall(String name) {
		Hall hall = Hall.builder().name(name).build();
		hallMapper.save(hall);
		log.info("Hall {} saved!", hall);
		return hall;
	}
	
	public Hall hallHallOfLegends() {
		return saveHall("Hall Of Legends");
	}
	
	public Hall hallShadowValey() {
		return saveHall("Shadow Valey");
	}
	
	public Hall hallUrbanJungle() {
		return saveHall("Urban Jungle");
	}
	
	public Hall hallWithSeat() {
		Hall hall = saveHall("Seat Hall");
		SeatType type = seatTypeSetup.seatTypeClassic();
		Seat seat = Seat.builder().hallId(hall.getId()).type(type).row(1).column(1).build();
		seatMapper.insert(seat);
		hall.setSeats(Arrays.asList(seat));
		return hall;
	}
}
