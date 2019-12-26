package rs.ac.bg.fon.cinema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.HallSeat;

@Mapper
public interface HallSeatMapper extends BaseMapper<HallSeat> {
	public Long count();

	public HallSeat getById(Long id);

	public int insert(HallSeat entity);

	public int update(HallSeat entity);

	public int deleteById(Long id);
	
	public List<HallSeat> getByHallId(Long hallId);
}
