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

import rs.ac.bg.fon.cinema.domain.Genre;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.ProductionCompany;
import rs.ac.bg.fon.cinema.exception.ServiceException;
import rs.ac.bg.fon.cinema.service.GenreService;
import rs.ac.bg.fon.cinema.service.MovieService;
import rs.ac.bg.fon.cinema.service.ProductionCompanyService;
import rs.ac.bg.fon.cinema.service.dto.MovieSearchRequest;

@RestController
@CrossOrigin
@RequestMapping(path = "api/movies")
public class MovieApi {

	@Autowired
	private MovieService movieService;

	@Autowired
	private GenreService genreService;

	@Autowired
	private ProductionCompanyService productionCompanyService;

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

	@PostMapping(path = "/search")
	public List<Movie> searchMovies(@RequestBody MovieSearchRequest request) {
		List<Movie> movies = movieService.searchMovies(request);
		if (movies.isEmpty())
			throw new ServiceException("No movies found!");
		return movies;
	}

	@DeleteMapping(value = "/{id}")
	public Boolean deleteMovieById(@PathVariable Long id) {
		return movieService.deleteMovie(id) == 1 ? true : false;
	}

	@GetMapping(value = "/{id}/genres")
	public List<Genre> getGenresByMovieId(@PathVariable Long id) {
		return genreService.getGenresByMovieId(id);
	}

	@GetMapping(value = "/{id}/productionCompanies")
	public List<ProductionCompany> getProductionCompaniesByMovieId(@PathVariable Long id) {
		return productionCompanyService.getProductionCompaniesByMovieId(id);
	}

}
