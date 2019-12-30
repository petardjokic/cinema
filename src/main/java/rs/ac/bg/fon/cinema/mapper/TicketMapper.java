package rs.ac.bg.fon.cinema.mapper;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.Ticket;

@Mapper
public interface TicketMapper extends BaseMapper<Ticket> {
	public Long count();

	public Ticket getById(Long id);

	public int insert(Ticket entity);

	public int update(Ticket entity);

	public int deleteById(Long id);
}
