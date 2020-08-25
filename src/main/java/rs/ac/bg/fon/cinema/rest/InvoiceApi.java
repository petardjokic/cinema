package rs.ac.bg.fon.cinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.exception.ServiceException;
import rs.ac.bg.fon.cinema.service.InvoiceService;
import rs.ac.bg.fon.cinema.service.dto.InvoiceSearchRequest;

@RestController
@CrossOrigin
@RequestMapping(path = "api/invoices")
public class InvoiceApi {
	
	@Autowired
	private InvoiceService invoiceService;
	
	@GetMapping(path = "/{id}")
	public Invoice getInvoiceById(@PathVariable Long id) {
		return invoiceService.getInvoiceById(id);
	}
	
	@GetMapping(path = "/")
	public List<Invoice> getAllInvoices() {
		return invoiceService.getAll();
	}
	
	@GetMapping(path = "/{id}/items")
	public Invoice getInvoiceItems(@PathVariable Long id) {
		return invoiceService.getInvoiceById(id);
	}
	
	@PostMapping
	public Invoice saveInvoice(@RequestBody Invoice invoice) {
		return invoiceService.saveInvoice(invoice);
	}
	
	@PostMapping(path = "/search")
	public List<Invoice> searchInvoices(@RequestBody InvoiceSearchRequest request) {
		List<Invoice> invoices = invoiceService.search(request);
		if(invoices.isEmpty()) 
			throw new ServiceException("No invoices found!");
		return invoices;
	}
	
	@DeleteMapping(path = "/{id}")
	public Invoice freezeInvoice(@PathVariable Long id) {
		return invoiceService.freeze(id);
	}

}
