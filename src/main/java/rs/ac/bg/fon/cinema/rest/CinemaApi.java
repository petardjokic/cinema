package rs.ac.bg.fon.cinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.cinema.service.DisplayService;
import rs.ac.bg.fon.cinema.service.InvoiceService;
import rs.ac.bg.fon.cinema.service.MovieService;
import rs.ac.bg.fon.cinema.service.dto.DisplayDto;
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
	
	
	@RequestMapping(value = "/api/movies/{id}", method = RequestMethod.GET)
	public MovieDto getMovieById(@PathVariable Long id) {
		return movieService.getMovieById(id);
	}
	
	@RequestMapping(value = "/api/movies", method = RequestMethod.GET)
	public List<MovieDto> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	@RequestMapping(value = "/api/displays/{id}", method = RequestMethod.GET)
	public DisplayDto getDisplayById(@PathVariable Long id) {
		return displayService.getDisplayById(id);
	}
	
	@RequestMapping(value = "/api/displays", method = RequestMethod.GET)
	public List<DisplayDto> getAllDisplays() {
		return displayService.getAllDisplays();
	}
	
	@RequestMapping(value = "/api/invoices/{id}", method = RequestMethod.GET)
	public InvoiceDto getInvoiceById(@PathVariable Long id) {
		return invoiceService.getInvoiceById(id);
	}
	
//	@RequestMapping(value = "/api/display", method = RequestMethod.GET)
//	public List<DisplayDto> getAllDisplays() {
//		return ticketService.getAllDisplays();
//	}
	
	
	
}
