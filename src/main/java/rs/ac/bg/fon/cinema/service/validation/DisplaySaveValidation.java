package rs.ac.bg.fon.cinema.service.validation;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.service.validation.filter.DisplaySaveCinemaWorkingDaysFilter;
import rs.ac.bg.fon.cinema.service.validation.filter.DisplaySaveCinemaWorkingHoursFilter;
import rs.ac.bg.fon.cinema.service.validation.filter.DisplaySaveDateInPastFilter;
import rs.ac.bg.fon.cinema.service.validation.filter.DisplaySaveHallBusy;

@Component
public class DisplaySaveValidation implements Validation<Display>{
	
	private final DisplaySaveCinemaWorkingDaysFilter workingDaysFilter;
	private final DisplaySaveCinemaWorkingHoursFilter workingHoursFilter;
	private final DisplaySaveDateInPastFilter dateInPastFilter;
	private final DisplaySaveHallBusy hallBusy;
	
	
	public DisplaySaveValidation(DisplaySaveCinemaWorkingDaysFilter workingDaysFilter,
								DisplaySaveCinemaWorkingHoursFilter workingHoursFilter,
								DisplaySaveDateInPastFilter dateInPastFilter,
								DisplaySaveHallBusy hallBusy) {
		this.workingDaysFilter = workingDaysFilter;
		this.workingHoursFilter = workingHoursFilter;
		this.dateInPastFilter = dateInPastFilter;
		this.hallBusy = hallBusy;
		
		this.workingDaysFilter.setSuccessor(this.workingHoursFilter);
		this.workingHoursFilter.setSuccessor(this.dateInPastFilter);
		dateInPastFilter.setSuccessor(this.hallBusy);
	}
	
	@Override
	public void validate(Display display) {
		workingDaysFilter.doFilter(display);
	}
	
}
