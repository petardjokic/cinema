package rs.ac.bg.fon.cinema.service.validation.filter;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.exception.ServiceException;
import rs.ac.bg.fon.cinema.service.DisplayService;

@Component
public class InvoiceCancelationToLateToCancelFilter extends ValidationFilter<Invoice>{
	
	@Autowired
	private DisplayService displayService;

	@Override
	protected void action(Invoice invoice) {
		boolean anyDisplayStarted = invoice.getItems().stream()
		.map(item -> displayService.getDisplayById(item.getDisplayId()))
		.anyMatch(display -> display.getStartsAt().isBefore(LocalDateTime.now()));
		if(anyDisplayStarted)
			throw new ServiceException("Freezing after some display from invoice started is not allowed.");
		
	}

}
