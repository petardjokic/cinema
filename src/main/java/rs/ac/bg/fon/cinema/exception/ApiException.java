package rs.ac.bg.fon.cinema.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@RequiredArgsConstructor
@SuperBuilder
@Getter
public class ApiException {
	
	private final String message;
	private final HttpStatus httpStatus;
	private final LocalDateTime timestamp;
}
