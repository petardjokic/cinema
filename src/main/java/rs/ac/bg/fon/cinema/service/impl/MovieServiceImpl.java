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
		Movie movie = Movie.builder().id(movieDto.getId()).title(movieDto.getTitle()).description(movieDto.getDescription()).duration(movieDto.getDuration()).releaseYear(movieDto.getReleaseYear()).build();
		movieMapper.save(movie);
		genreService.saveMovieGenres(movieDto.getId(), movieDto.getGenres());
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
	public void deleteMovie(Long movieId) {
		// TODO Auto-generated method stub
		
	}
	
	private MovieDto getMovieDto(Movie movie) {
		List<Genre> genres = genreService.getGenresByMovieId(movie.getId());
		List<ProductionCompany> prodCompanies = prodCompanyService.getProductionCompaniesByMovieId(movie.getId());
		return convertMovieToDto(movie, genres, prodCompanies);
	} 

	private MovieDto convertMovieToDto(Movie movie, List<Genre> genres, List<ProductionCompany> prodCompanies) {
		return MovieDto.builder().id(movie.getId()).title(movie.getTitle()).description(movie.getDescription())
				.duration(movie.getDuration()).releaseYear(movie.getReleaseYear()).genres(genres).productionCompanies(prodCompanies).build();
	}
}
