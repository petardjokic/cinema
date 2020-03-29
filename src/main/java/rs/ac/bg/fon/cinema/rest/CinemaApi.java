package rs.ac.bg.fon.cinema.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.service.InvoiceService;

@RestController
@CrossOrigin
public class CinemaApi {
	
	@Autowired
	private InvoiceService invoiceService;
	
	
	@RequestMapping(value = "/api/invoices/{id}", method = RequestMethod.GET)
	public Invoice getInvoiceById(@PathVariable Long id) {
		return invoiceService.getInvoiceById(id);
	}
	
}
