package rs.ac.bg.fon.cinema.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = ServiceException.class)
	public ResponseEntity<Object> handleApiException(ServiceException ex) {
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ApiException apiException = new ApiException(ex.getMessage(), badRequest, LocalDateTime.now());
		return new ResponseEntity<Object>(apiException, badRequest);
	}
	@ExceptionHandler(value = AuthException.class)
	public ResponseEntity<Object> handleAuthException(AuthException ex) {
		HttpStatus badRequest = HttpStatus.UNAUTHORIZED;
		ApiException apiException = new ApiException(ex.getMessage(), badRequest, LocalDateTime.now());
		return new ResponseEntity<Object>(apiException, badRequest);
	}
}
