package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.service.dto.MovieSearchRequest;


public interface MovieService {
	
	public Movie saveMovie(Movie movie);
	
	public int deleteMovie(Long movieId);
	
	public Movie getMovieById(Long movieId);
	
	public List<Movie> getAllMovies();
	
	public List<Movie> searchMovies(MovieSearchRequest request);
	
}
