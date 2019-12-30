package rs.ac.bg.fon.cinema.mapper;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.Genre;

@Mapper
public interface GenreMapper extends BaseMapper<Genre> {

	public Long count();

	public Genre getById(Long id);

	public int insert(Genre entity);

	public int update(Genre entity);

	public int deleteById(Long id);
}
