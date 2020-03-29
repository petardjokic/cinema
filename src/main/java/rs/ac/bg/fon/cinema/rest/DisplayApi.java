package rs.ac.bg.fon.cinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.service.DisplayService;

@RestController
@RequestMapping(path = "api/displays")
public class DisplayApi {

	@Autowired
	private DisplayService displayService;
	
	@GetMapping(value = "/{id}")
	public Display getDisplayById(@PathVariable Long id) {
		return displayService.getDisplayById(id);
	}
	
	@PostMapping
	public Display saveDisplay(@RequestBody Display display) {
		return displayService.saveDisplay(display);
	}
	
	@GetMapping
	public List<Display> getAllDisplays() {
		return displayService.getAllDisplays();
	}
	
	
}
