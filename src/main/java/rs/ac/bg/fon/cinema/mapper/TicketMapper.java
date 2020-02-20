package rs.ac.bg.fon.cinema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.service.dto.TicketDto;

@Mapper
public interface TicketMapper extends BaseMapper<Ticket> {
	public Long count();

	public Ticket getById(Long id);

	public int insert(Ticket entity);

	public int update(Ticket entity);

	public int deleteById(Long id);
	
	public List<Ticket> getByDisplayId(Long displayId);
	
	public List<TicketDto> getByInvoiceId(Long invoiceId);
}
