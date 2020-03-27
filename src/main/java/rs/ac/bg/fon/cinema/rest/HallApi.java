package rs.ac.bg.fon.cinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.cinema.domain.Hall;
import rs.ac.bg.fon.cinema.service.HallService;

@RestController
@RequestMapping(path = "api/halls")
public class HallApi {

	@Autowired
	private HallService hallService;

	@GetMapping
	public List<Hall> getAllHalls() {
		return hallService.getAllHalls();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Hall> getHallById(@PathVariable Long id) {
		try {
			Hall hall = hallService.getHallById(id);
			return ResponseEntity.ok(hall);
		} catch (IllegalStateException e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
