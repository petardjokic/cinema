package rs.ac.bg.fon.cinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.Genre;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.service.DisplayService;
import rs.ac.bg.fon.cinema.service.GenreService;
import rs.ac.bg.fon.cinema.service.HallService;
import rs.ac.bg.fon.cinema.service.InvoiceService;
import rs.ac.bg.fon.cinema.service.MovieService;
import rs.ac.bg.fon.cinema.service.dto.DisplayDto;
import rs.ac.bg.fon.cinema.service.dto.HallDto;
import rs.ac.bg.fon.cinema.service.dto.InvoiceDto;
import rs.ac.bg.fon.cinema.service.dto.MovieDto;

@RestController
public class CinemaApi {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private DisplayService displayService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private HallService hallService;
	
	@Autowired
	private GenreService genreService;
	
	
	@RequestMapping(value = "/api/movies/{id}", method = RequestMethod.GET)
	public MovieDto getMovieById(@PathVariable Long id) {
		return movieService.getMovieById(id);
	}
	
	@RequestMapping(value = "/api/movies", method = RequestMethod.GET)
	public List<MovieDto> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	@RequestMapping(value = "/api/movies/save", method = RequestMethod.POST)
	public Movie saveMovie(@RequestBody MovieDto movie) {
		return movieService.saveMovie(movie);
	}
	
	@RequestMapping(value = "/api/displays/{id}", method = RequestMethod.GET)
	public DisplayDto getDisplayById(@PathVariable Long id) {
		return displayService.getDisplayById(id);
	}
	
	@RequestMapping(value = "/api/displays", method = RequestMethod.GET)
	public List<DisplayDto> getAllDisplays() {
		return displayService.getAllDisplays();
	}
	
	@RequestMapping(value = "/api/movies", method = RequestMethod.POST)
	public Display saveDisplay(@RequestBody DisplayDto display) {
		return displayService.saveDisplay(display);
	}
	
	@RequestMapping(value = "/api/invoices/{id}", method = RequestMethod.GET)
	public InvoiceDto getInvoiceById(@PathVariable Long id) {
		return invoiceService.getInvoiceById(id);
	}
	
	@RequestMapping(value = "/api/halls", method = RequestMethod.GET)
	public List<HallDto> getAllHalls() {
		return hallService.getAllHalls();
	}
	
	@RequestMapping(value = "/api/halls/{id}", method = RequestMethod.GET)
	public HallDto getHallById(@PathVariable Long id) {
		return hallService.getHallById(id);
	}
	
	@RequestMapping(value = "/api/genres", method = RequestMethod.GET)
	public List<Genre> getAllGenre() {
		return genreService.getAllGenres();
	}
	
	@RequestMapping(value = "/api/genres/{id}", method = RequestMethod.GET)
	public Genre getGenreById(@PathVariable Long id) {
		return genreService.getGenreById(id);
	}
	
	
	
}
