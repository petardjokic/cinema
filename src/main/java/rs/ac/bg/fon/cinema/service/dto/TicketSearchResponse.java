package rs.ac.bg.fon.cinema.service.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import rs.ac.bg.fon.cinema.domain.Ticket;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class TicketSearchResponse {
	private List<Ticket> tickets;
}
