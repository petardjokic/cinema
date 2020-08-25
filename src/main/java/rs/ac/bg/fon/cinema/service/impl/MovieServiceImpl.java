package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.exception.ServiceException;
import rs.ac.bg.fon.cinema.mapper.MovieMapper;
import rs.ac.bg.fon.cinema.service.GenreService;
import rs.ac.bg.fon.cinema.service.MovieService;
import rs.ac.bg.fon.cinema.service.ProductionCompanyService;
import rs.ac.bg.fon.cinema.service.dto.MovieSearchRequest;
import rs.ac.bg.fon.cinema.service.validation.MovieDeleteValidation;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;

	@Autowired
	private GenreService genreService;

	@Autowired
	private ProductionCompanyService prodCompanyService;
	
	@Autowired
	private MovieDeleteValidation movieDeleteValidation;

	@Override
	@Transactional
	public Movie saveMovie(Movie movie) {
		log.info("Saving movie: {}", movie);
		movieMapper.save(movie);
		log.info("Saving movie genres");
		genreService.saveMovieGenres(movie);
		log.info("Saving movie production companies");
		prodCompanyService.saveMovieProductionCompanies(movie);
		return movie;
	}

	@Override
	public Movie getMovieById(Long movieId) {
		log.info("Getting movie with id: {}", movieId);
		Movie movieDb = movieMapper.getById(movieId);
		return Optional.ofNullable(movieDb)
				.orElseThrow(() -> new ServiceException(String.format("Movie with ID %s dont exist", movieId)));
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = movieMapper.getAll();
		return movies;
	}

	@Override
	public int deleteMovie(Long movieId) {
		movieDeleteValidation.validate(Movie.builder().id(movieId).build());
		return movieMapper.deleteById(movieId);
	}

	@Override
	public List<Movie> searchMovies(MovieSearchRequest request) {
		return movieMapper.search(request);
	}

}
