package rs.ac.bg.fon.cinema.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.cinema.domain.Genre;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.ProductionCompany;
import rs.ac.bg.fon.cinema.mapper.MovieMapper;
import rs.ac.bg.fon.cinema.service.GenreService;
import rs.ac.bg.fon.cinema.service.MovieService;
import rs.ac.bg.fon.cinema.service.ProductionCompanyService;
import rs.ac.bg.fon.cinema.service.dto.MovieDto;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;

	@Autowired
	private GenreService genreService;

	@Autowired
	private ProductionCompanyService prodCompanyService;

	@Override
	@Transactional
	public Movie saveMovie(MovieDto movieDto) {
		Movie movie = Movie.builder().id(movieDto.getId()).title(movieDto.getTitle())
				.trailerUri(movieDto.getTrailerUri()).description(movieDto.getDescription())
				.duration(movieDto.getDuration()).releaseYear(movieDto.getReleaseYear()).build();
		movie = movieMapper.save(movie);
		genreService.saveMovieGenres(movie.getId(), movieDto.getGenres());
		prodCompanyService.saveMovieProductionCompanies(movie.getId(), movieDto.getProductionCompanies());
		return movie;
	}

	@Override
	public MovieDto getMovieById(Long movieId) {
		Movie movie = movieMapper.getById(movieId);
		MovieDto movieDto = getMovieDto(movie);
		return movieDto;
	}

	@Override
	public List<MovieDto> getAllMovies() {
		List<MovieDto> moviesDto = new ArrayList<>();
		List<Movie> movies = movieMapper.getAll();
		movies.forEach(movie -> {
			MovieDto movieDto = getMovieDto(movie);
			moviesDto.add(movieDto);
		});
		return moviesDto;
	}

	@Override
	public int deleteMovie(Long movieId) {
		return movieMapper.deleteById(movieId);
	}

	private MovieDto getMovieDto(Movie movie) {
		List<Genre> genres = genreService.getGenresByMovieId(movie.getId());
		List<ProductionCompany> prodCompanies = prodCompanyService.getProductionCompaniesByMovieId(movie.getId());
		return convertMovieToDto(movie, genres, prodCompanies);
	}

	private MovieDto convertMovieToDto(Movie movie, List<Genre> genres, List<ProductionCompany> prodCompanies) {
		return MovieDto.builder().id(movie.getId()).title(movie.getTitle()).trailerUri(movie.getTrailerUri())
				.description(movie.getDescription()).duration(movie.getDuration()).releaseYear(movie.getReleaseYear())
				.genres(genres).productionCompanies(prodCompanies).build();
	}
}
