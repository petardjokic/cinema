package rs.ac.bg.fon.cinema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.InvoiceItem;
import rs.ac.bg.fon.cinema.service.dto.TicketSearchRequest;

@Mapper
public interface InvoiceItemMapper extends BaseMapper<InvoiceItem> {

	public Long count();

	public InvoiceItem getById(Long id);

	public int insert(InvoiceItem entity);

	public int update(InvoiceItem entity);

	public int deleteById(Long id);
	
	public List<InvoiceItem> searchInvoiceItems(TicketSearchRequest request);

	public void freezeByInvoiceId(Long invoiceId);
}
