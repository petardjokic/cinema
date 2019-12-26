package rs.ac.bg.fon.cinema.mapper;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.Hall;

@Mapper
public interface HallMapper extends BaseMapper<Hall> {
	
	public Long count();
	
	public Hall getById(Long id);

	public int insert(Hall entity);

	public int update(Hall entity);

	public int deleteById(Long id);
}
