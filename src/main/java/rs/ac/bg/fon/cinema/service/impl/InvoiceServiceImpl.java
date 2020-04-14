package rs.ac.bg.fon.cinema.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Cart;
import rs.ac.bg.fon.cinema.domain.CartItem;
import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.Invoice;
import rs.ac.bg.fon.cinema.domain.InvoiceDto;
import rs.ac.bg.fon.cinema.domain.Ticket;
import rs.ac.bg.fon.cinema.exception.ServiceException;
import rs.ac.bg.fon.cinema.mapper.InvoiceMapper;
import rs.ac.bg.fon.cinema.service.DisplayService;
import rs.ac.bg.fon.cinema.service.HallService;
import rs.ac.bg.fon.cinema.service.InvoiceService;
import rs.ac.bg.fon.cinema.service.TicketService;
import rs.ac.bg.fon.cinema.service.dto.TicketSearchRequest;
import rs.ac.bg.fon.cinema.service.dto.TicketSearchResponse;

@Service
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceMapper invoiceMapper;

	@Autowired
	private TicketService ticketService;

	@Autowired
	private DisplayService displayService;
	
	@Autowired
	private HallService hallService;

	@Override
	public Invoice getInvoiceById(Long invoiceId) {
		Invoice invoice = invoiceMapper.getById(invoiceId);
		
		Optional.ofNullable(invoice).orElseThrow(() ->
			new ServiceException(String.format("Invoice with ID  %s does not exist", invoiceId)));
		
		TicketSearchResponse searchResponse = ticketService.searchTickets(TicketSearchRequest.builder().invoiceId(invoiceId).build());
		List<Ticket> tickets = searchResponse.getTickets();
		invoice.setTickets(tickets);
		return invoice;
	}

	@Override
	public InvoiceDto getInvoiceDtoById(Long invoiceId) {
		Invoice invoice = getInvoiceById(invoiceId);//invoiceMapper.getById(invoiceId);
		
		Set<Long> displayIds = invoice.getTickets().stream().map(ticket -> ticket.getDisplayId()).collect(Collectors.toSet());
		
		List<Display> events = displayIds.stream()
			.map(id -> displayService.getDisplayByIdEager(id))
			.collect(Collectors.toList());
		
		events.forEach(display -> {
			List<Ticket> displayTickets = invoice.getTickets().stream()
			.filter(ticket -> display.getId().equals(ticket.getDisplayId()))
			.collect(Collectors.toList());
			display.setTickets(displayTickets);
			display.setSeatsAvailability(null);
		});
		return InvoiceDto.builder()
				.id(invoice.getId())
				.issuedAt(invoice.getIssuedAt())
				.active(invoice.getActive())
				.events(events)
				.build();
	}
	
	public Cart checkAndSave(Cart cart) {
		Cart retCart = new Cart();
		Invoice invoice = new Invoice();
		List<Ticket> tickets = new ArrayList<>();
		
		Set<Long> displayIds = cart.getCartItemsUnchecked().stream()
				.map(item -> item.getDisplayId())
				.collect(Collectors.toSet());
		
		displayIds.stream().forEach(displayId -> {
			Display display = displayService.getDisplayByIdEager(displayId);
			cart.getCartItemsUnchecked().stream()
					.filter(item -> item.getDisplayId().equals(displayId))
					.map(item -> Ticket.builder().displayId(displayId).seat(hallService.getSeatById(item.getSeatId())).build())
					.forEach(ticket -> {
						CartItem cartItem = CartItem.builder().displayId(displayId).seatId(ticket.getSeat().getId()).build();
						Ticket ticketDb = ticketService.findActiveByDisplayAndSeat(ticket);
						if (ticketDb == null) {
							retCart.getCartItemsChecked().add(cartItem);
							tickets.add(ticket);
						}else {
							retCart.getCartItemsUnchecked().add(cartItem);
						}
					});
		});
		invoice.setTickets(tickets);
		if(retCart.getCartItemsUnchecked().size() == 0) {
			invoice.setActive(true);
			saveInvoice(invoice);
			InvoiceDto invoiceDto = getInvoiceDtoById(invoice.getId());
			retCart.setInvoice(invoiceDto);
		}
		
		return retCart;
	}

	@Override
	@Transactional
	public Invoice saveInvoice(Invoice invoice) {
		invoiceMapper.save(invoice);
		ticketService.saveInvoiceTickets(invoice.getId(), invoice.getTickets());
		return invoice;
	}

	@Override
	public InvoiceDto freeze(Long invoiceId) {
		Invoice invoice = getInvoiceById(invoiceId);
		
//		if(!invoice.getActive())
//			throw new IllegalStateException("Invoice already freezed");
//		
//		boolean doesAnyDisplayStarted = invoice.getTickets().stream()
//			.map(ticket -> displayService.getDisplayByIdEager(ticket.getDisplayId()))
//			.anyMatch(display -> display.getStartsAt().isAfter(LocalDateTime.now()));
//		if(doesAnyDisplayStarted) 
//			throw new IllegalStateException("Cannot freeze invoice. Some displays already started");
		
		return freezeInvoice(invoice);
	}
	
	@Transactional
	public InvoiceDto freezeInvoice(Invoice invoice) {
		invoiceMapper.freezeInvoice(invoice.getId());
		ticketService.freezeTicketsByByInvoiceId(invoice.getId());
		return getInvoiceDtoById(invoice.getId());
	}
}
