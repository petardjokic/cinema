package rs.ac.bg.fon.cinema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.service.dto.InvoiceSearchRequest;

@Mapper
public interface InvoiceMapper extends BaseMapper<Invoice>{
	
	public Long count();

	public Invoice getById(Long id);

	public int insert(Invoice entity);

	public int update(Invoice entity);

	public int deleteById(Long id);

	public int freezeInvoice(Long id);

	public List<Invoice> search(InvoiceSearchRequest request);
}
