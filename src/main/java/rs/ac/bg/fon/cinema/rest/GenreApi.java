package rs.ac.bg.fon.cinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.cinema.domain.Genre;
import rs.ac.bg.fon.cinema.service.GenreService;

@RestController
@CrossOrigin
@RequestMapping(path = "api/genres")
public class GenreApi {

	@Autowired
	private GenreService genreService;
	
	@GetMapping
	public List<Genre> getAllGenres() {
		return genreService.getAllGenres();
	}
	
}
