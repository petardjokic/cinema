package rs.ac.bg.fon.cinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.service.DisplayService;
import rs.ac.bg.fon.cinema.service.InvoiceService;
import rs.ac.bg.fon.cinema.service.dto.DisplayDto;
import rs.ac.bg.fon.cinema.service.dto.InvoiceDto;

@RestController
@CrossOrigin
public class CinemaApi {
	
	
	@Autowired
	private DisplayService displayService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	@RequestMapping(value = "/api/displays/{id}", method = RequestMethod.GET)
	public DisplayDto getDisplayById(@PathVariable Long id) {
		return displayService.getDisplayById(id);
	}
	
	@RequestMapping(value = "/api/displays/save", method = RequestMethod.POST)
	public Display saveDisplay(@RequestBody DisplayDto display) {
		return displayService.saveDisplay(display);
	}
	
	@RequestMapping(value = "/api/displays", method = RequestMethod.GET)
	public List<DisplayDto> getAllDisplays() {
		return displayService.getAllDisplays();
	}
	
	@RequestMapping(value = "/api/invoices/{id}", method = RequestMethod.GET)
	public InvoiceDto getInvoiceById(@PathVariable Long id) {
		return invoiceService.getInvoiceById(id);
	}
	
}
