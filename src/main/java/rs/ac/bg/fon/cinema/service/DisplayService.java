package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.service.dto.DisplaySearchRequest;

public interface DisplayService {
	

	public Display getDisplayById(Long displayId);

	public List<Display> getAllDisplays();
	
	public Display saveDisplay(Display display);
	
	public int deleteDisplayById(Long displayId);

	public int cancelDisplay(Long id);

	public List<Display> searchDisplays(DisplaySearchRequest request);
	
}
