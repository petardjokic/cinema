package rs.ac.bg.fon.cinema.exception;

public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1355656253045331373L;

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable t) {
		super(message, t);
	}

}
