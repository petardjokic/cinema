package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.domain.Hall;

public interface HallService {

	public Hall getHallById(Long hallId);

	public List<Hall> getAllHalls();
}
