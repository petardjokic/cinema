package rs.ac.bg.fon.cinema.mapper.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Genre;
import rs.ac.bg.fon.cinema.mapper.GenreMapper;

@Component
@Slf4j
public class GenreSetup {
	
	@Autowired
	private GenreMapper genreMapper;
	
	private Genre saveGenre(String name) {
		Genre genre = Genre.builder().name(name).build();
		genreMapper.save(genre);
		log.info("Genre {} saved!", genre);
		return genre;
	}
	
	public Genre genreComedy() {
		return saveGenre("Comedy");
	}
	
	public Genre genreHorror() {
		return saveGenre("Horror");
	}
	
	public Genre genreAction() {
		return saveGenre("Action");
	}
}
