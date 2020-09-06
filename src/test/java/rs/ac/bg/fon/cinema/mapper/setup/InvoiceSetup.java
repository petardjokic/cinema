package rs.ac.bg.fon.cinema.mapper.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.mapper.InvoiceMapper;

@Component
@Slf4j
public class InvoiceSetup {
	@Autowired
	private InvoiceMapper invoiceMapper;
	
	private Invoice saveInvoice(Boolean active) {
		Invoice invoice = Invoice.builder().totalPrice(100D).active(active).build();
		invoiceMapper.save(invoice);
		log.info("Invoice {} saved!", invoice);
		return invoice;
	}
	
	public Invoice invoiceActive() {
		return saveInvoice(true);
	}
	
	public Invoice InvoiceInactive() {
		return saveInvoice(false);
	}
	
}
