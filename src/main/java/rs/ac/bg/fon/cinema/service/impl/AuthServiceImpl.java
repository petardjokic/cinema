package rs.ac.bg.fon.cinema.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import rs.ac.bg.fon.cinema.domain.User;
import rs.ac.bg.fon.cinema.exception.AuthException;
import rs.ac.bg.fon.cinema.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	private List<User> users;

	public AuthServiceImpl() {
		users = Arrays.asList(new User(1L, "pera", "Pera.brat123", "Petar Djokic"),
				new User(2L, "mika", "mika123", "Milos Radic"), new User(3L, "teo", "teo123", "Teodor Stosic"));
	}

	@Override
	public User login(User userArg) {
		return users.stream()
				.filter(user -> user.getUsername().equals(userArg.getUsername())
						&& user.getPassword().equals(userArg.getPassword()))
				.findFirst().orElseThrow(() -> new AuthException("Invalid username/password!"));
	}

}
