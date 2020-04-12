package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.domain.Genre;
import rs.ac.bg.fon.cinema.domain.Movie;

public interface GenreService {

	public Genre getGenreById(Long genreId);

	public List<Genre> getAllGenres();

	public List<Genre> getGenresByMovieId(Long movieId);

	public void saveMovieGenres(Movie movie);

	public Genre save(Genre genre);

}
