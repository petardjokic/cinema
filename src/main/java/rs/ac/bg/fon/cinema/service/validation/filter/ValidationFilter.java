package rs.ac.bg.fon.cinema.service.validation.filter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ValidationFilter<E> {

	private ValidationFilter<E> successor;

	public void setSuccessor(ValidationFilter<E> successor) {
		this.successor = successor;
	}

	public void doFilter(E entity) {
		log.info("Executing: {}", this.getClass().getSimpleName());
		action(entity);
		log.info("Action of: {} passed", this.getClass().getSimpleName());
		if (successor != null)
			successor.doFilter(entity);
	}

	abstract protected void action(E entity);
}
