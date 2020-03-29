package rs.ac.bg.fon.cinema.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.domain.InvoiceDto;
import rs.ac.bg.fon.cinema.service.InvoiceService;

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
	
	@GetMapping(path = "/dto/{id}")
	public InvoiceDto getInvoiceDtoById(@PathVariable Long id) {
		return invoiceService.getInvoiceDtoById(id);
	}

}
