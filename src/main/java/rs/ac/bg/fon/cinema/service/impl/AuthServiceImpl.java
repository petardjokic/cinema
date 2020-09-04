package rs.ac.bg.fon.cinema.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.User;
import rs.ac.bg.fon.cinema.exception.AuthException;
import rs.ac.bg.fon.cinema.mapper.UserMapper;
import rs.ac.bg.fon.cinema.service.AuthService;
import rs.ac.bg.fon.cinema.service.dto.UserSearchRequest;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

//	private List<User> users;
	@Autowired
	private UserMapper userMapper;

//	public AuthServiceImpl() {
//		users = Arrays.asList(new User(1L, "pera", "Pera.brat123", "Petar Djokic"),
//				new User(2L, "mika", "mika123", "Milos Radic"), new User(3L, "teo", "teo123", "Teodor Stosic"));
//	}

	@Override
	public User login(User userArg) {
		UserSearchRequest request = UserSearchRequest.builder().username(userArg.getUsername())
				.password(userArg.getPassword()).build();
		List<User> users = userMapper.search(request);
		log.info("LOGIN: {} ",userArg);
		log.info("RESULT: {}", users);
		if(users.isEmpty()) {
			throw new AuthException("Invalid username/password!");
		}
		return users.get(0);
// return users.stream()
//				.filter(user -> user.getUsername().equals(userArg.getUsername())
//						&& user.getPassword().equals(userArg.getPassword()))
//				.findFirst().orElseThrow(() -> new AuthException("Invalid username/password!"));
	}

}
