package rs.ac.bg.fon.cinema.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
public class TicketSearchRequest {
	private Long displayId;
	private Long invoiceId;
	private Long seatId;
	private Boolean active;
}
