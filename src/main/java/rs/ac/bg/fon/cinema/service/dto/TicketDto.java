package rs.ac.bg.fon.cinema.service.dto;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class TicketDto {

	private Long ticketId;
	private Long displayId;
	private LocalDateTime startsAt;
	private String movieTitle;
	private String hallName;
	private Long seatId;
	private int seatRow;
	private int seatColumn;
	private String seatType;
	private Boolean active;
}
