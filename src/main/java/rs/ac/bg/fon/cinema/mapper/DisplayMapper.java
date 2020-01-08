package rs.ac.bg.fon.cinema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.Display;

@Mapper
public interface DisplayMapper extends BaseMapper<Display> {

	public Long count();

	public Display getById(Long id);

	public int insert(Display entity);

	public int update(Display entity);

	public int deleteById(Long id);
	
	public List<Display> getAll();

}
