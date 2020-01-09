package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.service.dto.HallDto;

public interface HallService {

	public HallDto getHallById(Long hallId);

	public List<HallDto> getAllHalls();
}
