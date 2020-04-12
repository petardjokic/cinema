package rs.ac.bg.fon.cinema.service.validation;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.cinema.service.validation.filter.InvoiceCancelationAlreadyFreezedFilter;
import rs.ac.bg.fon.cinema.service.validation.filter.InvoiceCancelationToLateToCancelFilter;

@Component
public class InvoiceCancelationValidation {
	private final InvoiceCancelationAlreadyFreezedFilter alreadyFreezedFilter;
	private final InvoiceCancelationToLateToCancelFilter toLateToCancelFilter;
	
	public InvoiceCancelationValidation(InvoiceCancelationAlreadyFreezedFilter alreadyFreezedFilter,
										InvoiceCancelationToLateToCancelFilter toLateToCancelFilter) {
		this.alreadyFreezedFilter = alreadyFreezedFilter;
		this.toLateToCancelFilter = toLateToCancelFilter;
		
		this.alreadyFreezedFilter.setSuccessor(this.toLateToCancelFilter);
	}
	
	
}
