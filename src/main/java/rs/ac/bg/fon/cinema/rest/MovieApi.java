package rs.ac.bg.fon.cinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.service.MovieService;

@RestController
@CrossOrigin
@RequestMapping(path = "api/movies")
public class MovieApi {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping(value = "/{id}")
	public Movie getMovieById(@PathVariable Long id) {
		return movieService.getMovieById(id);
	}
	
	@GetMapping
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	@PostMapping
	public Movie saveMovie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}
	
	@DeleteMapping(value = "/{id}")
	public Boolean deleteMovieById(@PathVariable Long id) {
		return movieService.deleteMovie(id) == 1 ? true : false;
	}

}
