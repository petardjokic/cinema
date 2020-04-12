package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.domain.DisplayCategory;

public interface DisplayCategoryService {

	public DisplayCategory getById(Long id);
	
	public List<DisplayCategory> getAll();
	
}
