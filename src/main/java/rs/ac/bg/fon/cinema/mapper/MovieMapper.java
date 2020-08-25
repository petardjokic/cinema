package rs.ac.bg.fon.cinema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.service.dto.MovieSearchRequest;

@Mapper
public interface MovieMapper extends BaseMapper<Movie> {

	public Long count();

	public Movie getById(Long id);

	public int insert(Movie entity);

	public int update(Movie entity);

	public int deleteById(Long id);
	
	public List<Movie> getAll();
	
	public List<Movie> search(MovieSearchRequest request);

}
