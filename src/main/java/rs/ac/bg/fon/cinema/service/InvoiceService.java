package rs.ac.bg.fon.cinema.service;

import rs.ac.bg.fon.cinema.domain.Cart;
import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.domain.InvoiceDto;

public interface InvoiceService {
	
	public Invoice getInvoiceById(Long invoiceId);
	
	public InvoiceDto getInvoiceDtoById(Long invoiceId);
	
	public Invoice saveInvoice(Invoice invoiceDto);
	
	public Cart checkAndSave(Cart cart);

	public InvoiceDto freeze(Long id);
}
