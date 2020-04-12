package rs.ac.bg.fon.cinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.cinema.domain.DisplayCategory;
import rs.ac.bg.fon.cinema.service.DisplayCategoryService;

@RestController
@CrossOrigin
@RequestMapping(path = "api/categories")
public class CategoriesApi {
	
	@Autowired
	private DisplayCategoryService categoryService;

	@GetMapping
	public List<DisplayCategory> getallCategories() {
		return categoryService.getAll();
	}
}
