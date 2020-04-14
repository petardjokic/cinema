package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.domain.Display;

public interface DisplayService {
	
	public Display getDisplayByIdLazy(Long displayId);

	public Display getDisplayByIdEager(Long displayId);

	public List<Display> getAllDisplays();
	
	public Display saveDisplay(Display display);
	
	public int deleteDisplayById(Long displayId);

	public int cancelDisplay(Long id);
	
}
