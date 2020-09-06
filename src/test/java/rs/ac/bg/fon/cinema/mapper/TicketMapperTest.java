package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.domain.InvoiceItem;
import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.mapper.setup.DisplaySetup;
import rs.ac.bg.fon.cinema.mapper.setup.InvoiceSetup;

@Slf4j
class TicketMapperTest extends BaseMapperTest{
	
	@Autowired
	private InvoiceItemMapper invoiceItemMapper;
	
	@Autowired
	private InvoiceSetup invoiceSetup;
	
	@Autowired
	private DisplaySetup displaySetup;
	
	@Test
	void testCRUD() {
		
		Display display = displaySetup.displayThirdWithHallSeat();
		
		Invoice invoice = invoiceSetup.invoiceActive();
		
		log.info("Adding a new ticket");
		InvoiceItem invoiceItem = InvoiceItem.builder()
				.displayId(display.getId())
				.invoiceId(invoice.getId())
				.seat(display.getHall().getSeats().get(0))
				.active(new Boolean(true))
				.price(100D)
				.build();
		assertEquals(1,invoiceItemMapper.insert(invoiceItem));
		
		log.info("Getting ticket");
		InvoiceItem invoiceItemDb = invoiceItemMapper.getById(invoiceItem.getId());
		assertEquals(invoiceItem.getId(), invoiceItemDb.getId());
		assertEquals(invoiceItem.getDisplayId(), invoiceItemDb.getDisplayId());
		assertEquals(invoiceItem.getActive(), invoiceItemDb.getActive());
		assertEquals(invoiceItem.getSeat().getId(), invoiceItemDb.getSeat().getId());
		assertEquals(invoiceItem.getSeat().getRow(), invoiceItemDb.getSeat().getRow());
		assertEquals(invoiceItem.getSeat().getColumn(), invoiceItemDb.getSeat().getColumn());
		assertEquals(invoiceItem.getSeat().getType().getId(), invoiceItemDb.getSeat().getType().getId());
		assertEquals(invoiceItem.getSeat().getType().getName(), invoiceItemDb.getSeat().getType().getName());
		
		log.info("Updating ticket");
		assertEquals(1, invoiceItemMapper.update(invoiceItem));
		
		log.info("Getting ticket");
		invoiceItemDb = invoiceItemMapper.getById(invoiceItem.getId());
		assertEquals(invoiceItem.getId(), invoiceItemDb.getId());
		assertEquals(invoiceItem.getDisplayId(), invoiceItemDb.getDisplayId());
		assertEquals(invoiceItem.getActive(), invoiceItemDb.getActive());
		assertEquals(invoiceItem.getSeat().getId(), invoiceItemDb.getSeat().getId());
		assertEquals(invoiceItem.getSeat().getRow(), invoiceItemDb.getSeat().getRow());
		assertEquals(invoiceItem.getSeat().getColumn(), invoiceItemDb.getSeat().getColumn());
		assertEquals(invoiceItem.getSeat().getType().getId(), invoiceItemDb.getSeat().getType().getId());
		assertEquals(invoiceItem.getSeat().getType().getName(), invoiceItemDb.getSeat().getType().getName());
		
		log.info("Deleting ticket");
		assertEquals(1, invoiceItemMapper.deleteById(invoiceItem.getId()));
		
	}
	
	

}
