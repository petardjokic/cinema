package rs.ac.bg.fon.cinema.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.bg.fon.cinema.domain.Genre;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.ProductionCompany;
import rs.ac.bg.fon.cinema.mapper.MovieMapper;
import rs.ac.bg.fon.cinema.service.GenreService;
import rs.ac.bg.fon.cinema.service.MovieService;
import rs.ac.bg.fon.cinema.service.ProductionCompanyService;
import rs.ac.bg.fon.cinema.service.dto.MovieDto;

public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;

	@Autowired
	private GenreService genreService;

	@Autowired
	private ProductionCompanyService prodCompanyService;

	@Override
	public MovieDto getMovieById(Long movieId) {
		List<Genre> genres = genreService.getGenresByMovieId(movieId);
		List<ProductionCompany> prodCompanies = prodCompanyService.getProductionCompaniesByMovieId(movieId);
		Movie movie = movieMapper.getById(movieId);
		MovieDto movieDto = convertMovieToDto(movie, genres, prodCompanies);
		return movieDto;
	}

	@Override
	public List<MovieDto> getAllMovies() {
		List<MovieDto> moviesDto = new ArrayList<>();
		List<Movie> movies = movieMapper.getAll();
		movies.forEach(movie -> {
			List<Genre> genres = genreService.getGenresByMovieId(movie.getId());
			List<ProductionCompany> prodCompanies = prodCompanyService.getProductionCompaniesByMovieId(movie.getId());
			MovieDto movieDto = convertMovieToDto(movie, genres, prodCompanies);
			moviesDto.add(movieDto);
		});
		return moviesDto;
	}

	private MovieDto convertMovieToDto(Movie movie, List<Genre> genres, List<ProductionCompany> prodCompanies) {
		return MovieDto.builder().id(movie.getId()).title(movie.getTitle()).description(movie.getDescription())
				.duration(movie.getDuration()).releaseYear(movie.getReleaseYear()).build();
	}
}
