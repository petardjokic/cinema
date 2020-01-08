package rs.ac.bg.fon.cinema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.MovieProductionCompany;

@Mapper
public interface MovieProductionCompanyMapper extends BaseMapper<MovieProductionCompany>{

	public Long count();
	
	public MovieProductionCompany getById(Long id);

	public int insert(MovieProductionCompany entity);

	public int update(MovieProductionCompany entity);

	public int deleteById(Long id);
	
	public List<MovieProductionCompany> getByMovieId(Long movieId);
}
