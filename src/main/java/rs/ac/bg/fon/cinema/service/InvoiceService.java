package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.service.dto.InvoiceSearchRequest;

public interface InvoiceService {
	
	public Invoice getInvoiceById(Long invoiceId);
	
	public Invoice saveInvoice(Invoice invoice);
	
	public Invoice freeze(Long id);

	public List<Invoice> getAll();
	
	public List<Invoice> search(InvoiceSearchRequest request);
}
