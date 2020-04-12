package rs.ac.bg.fon.cinema.mapper.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.SeatType;
import rs.ac.bg.fon.cinema.mapper.SeatTypeMapper;

@Component
@Slf4j
public class SeatTypeSetup {

	@Autowired
	private SeatTypeMapper SeatTypeMapper;
	
	private SeatType saveSeatType(String name) {
		SeatType seatType = SeatType.builder().name(name).build();
		SeatTypeMapper.save(seatType);
		log.info("Seat Type {} saved!", seatType);
		return seatType;
	}
	
	public SeatType seatTypeClassic() {
		return saveSeatType("Classic");
	}
	
	public SeatType seatTypeVip() {
		return saveSeatType("Vip");
	}
	
	public SeatType seatTypeLove() {
		return saveSeatType("Love");
	}
}
