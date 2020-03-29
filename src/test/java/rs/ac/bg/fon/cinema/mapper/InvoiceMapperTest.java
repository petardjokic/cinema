package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.domain.Ticket;

@Slf4j
class InvoiceMapperTest extends BaseMapperTest{

	@Autowired
	private InvoiceMapper invoiceMapper;

	@Test
	void testCRUD() {

		log.info("Adding a new invoice");
		Invoice invoice = Invoice.builder().issuedAt(LocalDateTime.now()).active(new Boolean(true)).build();
		assertEquals(1, invoiceMapper.insert(invoice));
		
		log.info("Getting invoice");
		Invoice invoiceDb = invoiceMapper.getById(invoice.getId());
		assertEquals(invoice.getId(), invoiceDb.getId());
		assertEquals(invoice.getActive(), invoiceDb.getActive());
		
		log.info("Updating invoice");
		invoice.setActive(new Boolean(false));
		assertEquals(1, invoiceMapper.update(invoice));
		
		log.info("Getting invoice");
		invoiceDb = invoiceMapper.getById(invoice.getId());
		assertEquals(invoice.getId(), invoiceDb.getId());
		assertEquals(invoice.getIssuedAt(), invoiceDb.getIssuedAt());
		assertEquals(invoice.getActive(), invoiceDb.getActive());
		
		log.info("Deleting invoice");
		assertEquals(1, invoiceMapper.deleteById(invoice.getId()));

	}
	
	@Test
	public void testSet() {
		List<Ticket> tickets = Arrays.asList(
				Ticket.builder().displayId(1L).build(),
				Ticket.builder().displayId(1L).build(),
				Ticket.builder().displayId(2L).build(),
				Ticket.builder().displayId(3L).build(),
				Ticket.builder().displayId(4L).build(),
				Ticket.builder().displayId(5L).build(),
				Ticket.builder().displayId(4L).build()
				);
		Set<Long> set = tickets.stream()
		.map(ticket -> ticket.getDisplayId())
		.collect(Collectors.toSet());
		System.out.println(set);
	}

}
