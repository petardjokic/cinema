package rs.ac.bg.fon.cinema.service.dto;


import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class TicketDto {

	private Long ticketId;
	private Long displayId;
	private LocalDateTime startsAt;
	private String movieTitle;
	private String hallName;
	private int seatRow;
	private int seatColumn;
	private String seatType;
}
