package rs.ac.bg.fon.cinema.service;

import rs.ac.bg.fon.cinema.service.dto.InvoiceDto;

public interface InvoiceService {
	
	public InvoiceDto getInvoiceById(Long invoiceId);
}
