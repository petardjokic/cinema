package rs.ac.bg.fon.cinema.service.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class InvoiceDto {
	private Long id;
	private LocalDateTime issuedAt;
	private List<TicketDto> tickets;
	private Boolean active;
}
