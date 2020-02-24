package rs.ac.bg.fon.cinema.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	@Transactional
	public Genre save(Genre genre) {
		return genreMapper.save(genre);
	}

	@Override
	@Transactional
	public void saveMovieGenres(Long movieId, List<Genre> genres) {
		List<MovieGenre> movieGenresDb = movieGenreMapper.getByMovieId(movieId);
		List<MovieGenre> movieGenresParam = new ArrayList<>();
		genres.stream().forEach(genre -> {
			movieGenresParam.add(new MovieGenre(null, movieId, genre.getId()));
		});

		List<MovieGenre> movieGenresToDelete = movieGenresDb.stream()
				.filter(movieGenreDb -> !movieGenresParam.contains(movieGenreDb)).collect(Collectors.toList());
		List<MovieGenre> genresToAdd = movieGenresParam.stream()
				.filter(movieGenre -> !movieGenresDb.contains(movieGenre)).collect(Collectors.toList());

		movieGenresToDelete.stream().forEach(movieGenre -> {
			movieGenreMapper.deleteById(movieGenre.getId());
		});
		genresToAdd.stream().forEach(movieGenre -> {
			movieGenreMapper.save(movieGenre);
		});
	}

}
