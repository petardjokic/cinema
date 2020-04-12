package rs.ac.bg.fon.cinema.service.validation.filter;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.exception.ServiceException;

@Component
public class InvoiceCancelationAlreadyFreezedFilter extends ValidationFilter<Invoice> {

	@Override
	protected void action(Invoice invoice) {
		if (!invoice.getActive())
			throw new ServiceException("Invoice is already freezed.");
	}

}
