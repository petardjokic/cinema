package rs.ac.bg.fon.cinema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.Seat;

@Mapper
public interface SeatMapper extends BaseMapper<Seat> {
	public Long count();

	public Seat getById(Long id);

	public int insert(Seat entity);

	public int update(Seat entity);

	public int deleteById(Long id);
	
	public List<Seat> getByHallId(Long hallId);
}
