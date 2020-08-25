package rs.ac.bg.fon.cinema.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.cinema.domain.User;
import rs.ac.bg.fon.cinema.service.AuthService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/auth")
public class AuthApi {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping(path = "/login")
	private User login(@RequestBody User user) {
		return authService.login(user);
	}
}
