package rs.ac.bg.fon.cinema.service.dto;


import java.time.LocalDateTime;

import lombok.Data;

@Data
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
