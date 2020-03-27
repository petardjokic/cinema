package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Genre;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.MovieGenre;
import rs.ac.bg.fon.cinema.mapper.GenreMapper;
import rs.ac.bg.fon.cinema.mapper.MovieGenreMapper;
import rs.ac.bg.fon.cinema.service.GenreService;

@Service
@Slf4j
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
	public void saveMovieGenres(Movie movie) {
		List<MovieGenre> movieGenresDb = movieGenreMapper.getByMovieId(movie.getId());
		
		List<MovieGenre> movieGenresParam = movie.getGenres().stream()
				.map(genre -> (new MovieGenre(null, movie.getId(), genre.getId())))
				.collect(Collectors.toList());

		// delete removed Genres
		log.info("Deleting removed movie genres for movieId: {}", movie.getId());
		movieGenresDb.stream()
			.filter(movieGenreDb -> !movieGenresParam.contains(movieGenreDb))
			.forEach(movieGenre -> movieGenreMapper.deleteById(movieGenre.getId()));

		// save added Genres
		log.info("Saving added movie genres for movieId: {}", movie.getId());
		movieGenresParam.stream()
			.filter(movieGenre -> !movieGenresDb.contains(movieGenre))
			.forEach(movieGenre -> movieGenreMapper.save(movieGenre));
	}

}
