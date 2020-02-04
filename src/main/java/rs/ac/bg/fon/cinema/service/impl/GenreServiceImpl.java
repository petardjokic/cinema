package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.cinema.domain.Genre;
import rs.ac.bg.fon.cinema.domain.MovieGenre;
import rs.ac.bg.fon.cinema.mapper.GenreMapper;
import rs.ac.bg.fon.cinema.mapper.MovieGenreMapper;
import rs.ac.bg.fon.cinema.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreMapper genreMapper;

	@Autowired
	private MovieGenreMapper movieGenreMapper;

	@Override
	public Genre getGenreById(Long genreId) {
		return genreMapper.getById(genreId);
	}

	@Override
	public List<Genre> getAllGenres() {
		return genreMapper.getAll();
	}

	@Override
	public List<Genre> getGenresByMovieId(Long movieId) {
		List<MovieGenre> movieGenres = movieGenreMapper.getByMovieId(movieId);
		return movieGenres.stream().map(movieGenre -> {
			return genreMapper.getById(movieGenre.getGenreId());
		}).collect(Collectors.toList());
	}

}
