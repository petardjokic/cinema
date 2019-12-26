package rs.ac.bg.fon.cinema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.SeatType;

@Mapper
public interface SeatTypeMapper extends BaseMapper<SeatType> {
	
	public Long count();

	public SeatType getById(Long id);

	public int insert(SeatType entity);

	public int update(SeatType entity);

	public int deleteById(Long id);

	public List<SeatType> getAll();
}
