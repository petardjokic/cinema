package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.service.dto.DisplayDto;

public interface DisplayService {

	public DisplayDto getDisplayById(Long displayId);

	public List<DisplayDto> getAllDisplays();
}
