package rs.ac.bg.fon.cinema.service.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import rs.ac.bg.fon.cinema.domain.Ticket;

@Data
public class InvoiceDto {
	private Long id;
	private LocalDateTime issuedAt;
	private List<Ticket> tickets;
	private Boolean active;
}
