package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.domain.Hall;
import rs.ac.bg.fon.cinema.domain.Seat;

public interface HallService {

	public Hall getHallById(Long hallId);

	public List<Hall> getAllHalls();
	
	public List<Seat> getSeatsByHallId(Long hallId);
}
