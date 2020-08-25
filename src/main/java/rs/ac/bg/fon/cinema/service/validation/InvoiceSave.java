package rs.ac.bg.fon.cinema.service.validation;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.service.validation.filter.InvoiceItemsSeatAvailability;

@Component
public class InvoiceSave implements Validation<Invoice>{
	
	private InvoiceItemsSeatAvailability seatAvailability;
	
	public InvoiceSave(InvoiceItemsSeatAvailability seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	@Override
	public void validate(Invoice t) {
		seatAvailability.doFilter(t);
		
	}

}
