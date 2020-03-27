package rs.ac.bg.fon.cinema.service.dto;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import rs.ac.bg.fon.cinema.domain.Hall;
import rs.ac.bg.fon.cinema.domain.Movie;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class TicketDto {

	private Long ticketId;
	private Long displayId;
	private LocalDateTime startsAt;
	private Boolean active;
	private Movie movie;
	private Hall hall;
	private HallSeatDto seat; 
	
//	private String movieTitle;
//	private String hallName;
//	private Long seatId;
//	private int seatRow;
//	private int seatColumn;
//	private Long seatTypeId;
//	private String seatTypeName;
}
