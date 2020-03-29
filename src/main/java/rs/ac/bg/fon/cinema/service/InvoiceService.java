package rs.ac.bg.fon.cinema.service;

import rs.ac.bg.fon.cinema.domain.Invoice;

public interface InvoiceService {
	
	public Invoice getInvoiceById(Long invoiceId);
	
	public Invoice saveInvoice(Invoice invoiceDto);
}
