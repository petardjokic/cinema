package rs.ac.bg.fon.cinema.mapper.setup;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.DisplayCategory;
import rs.ac.bg.fon.cinema.domain.Hall;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.mapper.DisplayMapper;

@Component
@Slf4j
public class DisplaySetup {
	@Autowired
	private DisplayMapper DisplayMapper;
	
	@Autowired
	private MovieSetup movieSetup;
	
	@Autowired
	private HallSetup hallSetup;
	
	@Autowired
	private DisplayCategorySetup categorySetup; 

	private Display saveDisplay(Movie movie, Hall hall, DisplayCategory category) {
		Display display = Display.builder()
				.movie(movie)
				.hall(hall)
				.category(category)
				.startsAt(LocalDateTime.now()).build();
		DisplayMapper.save(display);
		log.info("Display {} saved!", display);
		return display;
	}

	public Display displayFirst() {
		Movie  movie = movieSetup.movieBasicInstinct();
		Hall hall = hallSetup.hallHallOfLegends();
		DisplayCategory category = categorySetup.displayCategoryPremiere();
		return saveDisplay(movie, hall, category);
	}

	public Display displaySecond() {
		Movie  movie = movieSetup.moviePulpFiction();
		Hall hall = hallSetup.hallShadowValey();
		DisplayCategory category = categorySetup.displayCategoryPremiereBlockbuster();
		return saveDisplay(movie, hall, category);
	}

	public Display displayThirdWithHallSeat() {
		Movie  movie = movieSetup.movieTheShawshankRedemption();
		Hall hall = hallSetup.hallWithSeat();
		DisplayCategory category = categorySetup.displayCategoryRegular();
		return saveDisplay(movie, hall, category);
	}
}
