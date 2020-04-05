package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Genre;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.ProductionCompany;
import rs.ac.bg.fon.cinema.mapper.MovieMapper;
import rs.ac.bg.fon.cinema.service.GenreService;
import rs.ac.bg.fon.cinema.service.MovieService;
import rs.ac.bg.fon.cinema.service.ProductionCompanyService;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;

	@Autowired
	private GenreService genreService;

	@Autowired
	private ProductionCompanyService prodCompanyService;

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
		Movie movieDb = movieMapper.getById(movieId);
		Optional.ofNullable(movieDb)
			.ifPresent(movie -> {
				List<Genre> genres = genreService.getGenresByMovieId(movie.getId());
				List<ProductionCompany> productionCompanies = prodCompanyService.getProductionCompaniesByMovieId(movie.getId());
				movie.setGenres(genres);
				movie.setProductionCompanies(productionCompanies);
			});
		return movieDb;
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = movieMapper.getAll();
//		movies.forEach(movie -> {
//			List<Genre> genres = genreService.getGenresByMovieId(movie.getId());
//			List<ProductionCompany> productionCompanies = prodCompanyService.getProductionCompaniesByMovieId(movie.getId());
//			movie.setGenres(genres);
//			movie.setProductionCompanies(productionCompanies);
//		});
		return movies;
	}

	@Override
	public int deleteMovie(Long movieId) {
		return movieMapper.deleteById(movieId);
	}

}
