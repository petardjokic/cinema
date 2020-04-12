package rs.ac.bg.fon.cinema.service.validation;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.service.validation.filter.DisplaySaveCinemaWorkingDaysFilter;
import rs.ac.bg.fon.cinema.service.validation.filter.DisplaySaveCinemaWorkingHoursFilter;

@Component
public class DisplaySaveValidation implements Validation<Display>{
	
	private final DisplaySaveCinemaWorkingDaysFilter workingDaysFilter;
	private final DisplaySaveCinemaWorkingHoursFilter workingHoursFilter;
	
	
	public DisplaySaveValidation(DisplaySaveCinemaWorkingDaysFilter workingDaysFilter,
								DisplaySaveCinemaWorkingHoursFilter workingHoursFilter) {
		this.workingDaysFilter = workingDaysFilter;
		this.workingHoursFilter = workingHoursFilter;
		
		this.workingDaysFilter.setSuccessor(this.workingHoursFilter);
	}
	
	@Override
	public void validate(Display display) {
		workingDaysFilter.doFilter(display);
	}
	
}
