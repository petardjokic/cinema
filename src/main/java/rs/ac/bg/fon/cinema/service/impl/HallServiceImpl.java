package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.cinema.domain.Hall;
import rs.ac.bg.fon.cinema.domain.Seat;
import rs.ac.bg.fon.cinema.mapper.HallMapper;
import rs.ac.bg.fon.cinema.mapper.SeatMapper;
import rs.ac.bg.fon.cinema.service.HallService;

@Service
public class HallServiceImpl implements HallService {

	@Autowired
	private HallMapper hallMapper;

	@Autowired
	private SeatMapper seatMapper;

	@Override
	public Hall getHallById(Long hallId) {
		Hall hallDb = hallMapper.getById(hallId);
		Optional.ofNullable(hallDb)
				.ifPresent(hall -> hall.setSeats(getSeatsByHallId(hallId)));
		Optional.ofNullable(hallDb)
		.orElseThrow(() -> new IllegalStateException(String.format("Hall with ID: %s does not exist!", hallId)));
		return hallDb;
	}

	@Override
	public List<Hall> getAllHalls() {
		return hallMapper.getAll();
	}
	
	public List<Seat> getSeatsByHallId(Long hallId) {
		return seatMapper.getByHallId(hallId);
	}

}
