package rs.ac.bg.fon.cinema.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.Hall;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.mapper.BaseMapperTest;
import rs.ac.bg.fon.cinema.mapper.setup.DisplayCategorySetup;
import rs.ac.bg.fon.cinema.mapper.setup.HallSetup;
import rs.ac.bg.fon.cinema.mapper.setup.MovieSetup;
import rs.ac.bg.fon.cinema.service.DisplayService;
import rs.ac.bg.fon.cinema.service.validation.DisplaySaveValidation;
import rs.ac.bg.fon.cinema.service.validation.filter.DisplaySaveCinemaWorkingDaysFilter;
import rs.ac.bg.fon.cinema.service.validation.filter.DisplaySaveCinemaWorkingHoursFilter;
import rs.ac.bg.fon.cinema.service.validation.filter.ValidationFilter;

@Slf4j
class DisplayServiceImplTest extends BaseMapperTest{
	
	@Autowired
	private DisplayService displayService;
	
	@Autowired
	private MovieSetup movieSetup;
	
	@Autowired
	private HallSetup hallSetup;
	
	@Autowired
	private DisplayCategorySetup categorySetup;
	
	@Autowired
	private DisplaySaveValidation displaySaveValidation;
	

	@Test
	void savingDisplay() {
		Movie movie1 = movieSetup.movieBasicInstinct();
		Movie movie2 = movieSetup.moviePulpFiction();
		Hall hall1 = hallSetup.hallWithSeat();
		
	}
	
	@Test
	void testChain() {
		Movie m = Movie.builder().duration(120).build();
		Display display = Display.builder().movie(m).startsAt(LocalDateTime.now().plusDays(1)).build();
		displaySaveValidation.validate(display);
	}

}
