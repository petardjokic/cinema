package rs.ac.bg.fon.cinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.cinema.domain.Genre;
import rs.ac.bg.fon.cinema.service.GenreService;

@RestController
@RequestMapping(path = "api/genres")
public class GenreApi {

	@Autowired
	private GenreService genreService;
	
	@GetMapping
	public List<Genre> getAllGenres() {
		return genreService.getAllGenres();
	}
	
	@GetMapping(value = "/{id}")
	public Genre getGenreById(@PathVariable Long id) {
		return genreService.getGenreById(id);
	}
	
	@PostMapping
	public Genre saveGenre(@RequestBody Genre genre) {
		return genreService.save(genre);
	}
	
}
