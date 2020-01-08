package rs.ac.bg.fon.cinema.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.bg.fon.cinema.domain.Hall;
import rs.ac.bg.fon.cinema.domain.HallSeat;
import rs.ac.bg.fon.cinema.domain.SeatType;
import rs.ac.bg.fon.cinema.mapper.HallMapper;
import rs.ac.bg.fon.cinema.mapper.HallSeatMapper;
import rs.ac.bg.fon.cinema.mapper.SeatTypeMapper;
import rs.ac.bg.fon.cinema.service.HallService;
import rs.ac.bg.fon.cinema.service.dto.HallDto;
import rs.ac.bg.fon.cinema.service.dto.HallSeatDto;

public class HallServiceImpl implements HallService {

	@Autowired
	private HallMapper hallMapper;

	@Autowired
	private HallSeatMapper hallSeatMapper;

	@Autowired
	private SeatTypeMapper seatTypeMapper;

	public HallDto getHallById(Long hallId) {
		Hall hallDao = hallMapper.getById(hallId);
		HallDto hallDto = convertToDto(hallDao);
		return hallDto;
	}

	public List<HallDto> getAllHalls() {
		List<HallDto> halls = new ArrayList<>();
		List<Hall> hallsDao = hallMapper.getAll();
		hallsDao.stream().forEach(hallDao -> {
			HallDto hallDto = convertToDto(hallDao);
			halls.add(hallDto);
		});
		return halls;
	}
	
	private HallDto convertToDto(Hall hallDao) {
		List<HallSeat> hallseatsDao = hallSeatMapper.getByHallId(hallDao.getId());
		List<HallSeatDto> hallseats = new ArrayList<>();
		hallseatsDao.stream().forEach(seat -> {
			SeatType type = seatTypeMapper.getById(seat.getSeatTypeId());
			hallseats.add(new HallSeatDto(seat.getId(), type, seat.getRow(), seat.getColumn()));
		});
		return new HallDto(hallDao.getId(), hallDao.getName(), hallseats);
	}
	
	

}
