package rs.ac.bg.fon.cinema.service;

import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.service.dto.InvoiceDto;

public interface InvoiceService {
	
	public InvoiceDto getInvoiceById(Long invoiceId);
	
	public Invoice saveInvoice(InvoiceDto invoiceDto);
}
