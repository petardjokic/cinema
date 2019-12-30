package rs.ac.bg.fon.cinema.mapper;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.MovieGenre;

@Mapper
public interface MovieGenreMapper extends BaseMapper<MovieGenre>{

	public Long count();
	
	public MovieGenre getById(Long id);

	public int insert(MovieGenre entity);

	public int update(MovieGenre entity);

	public int deleteById(Long id);
}
