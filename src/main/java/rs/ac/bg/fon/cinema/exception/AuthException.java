package rs.ac.bg.fon.cinema.exception;

public class AuthException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2919512882554705604L;

	public AuthException(String message) {
		super(message);
	}

	public AuthException(String message, Throwable t) {
		super(message, t);
	}
}
