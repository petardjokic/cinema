package rs.ac.bg.fon.cinema.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import rs.ac.bg.fon.cinema.domain.SeatType;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class HallSeatDto {

	private Long id;
	private SeatType seatType;
	private int row;
	private int column;
}
