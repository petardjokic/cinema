package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.service.dto.MovieDto;


public interface MovieService {
	
	public Movie saveMovie(MovieDto movie);
	
	public void deleteMovie(Long movieId);
	
	public MovieDto getMovieById(Long movieId);
	
	public List<MovieDto> getAllMovies();
	
}
