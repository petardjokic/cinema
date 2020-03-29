package rs.ac.bg.fon.cinema.domain;

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
public class DisplayPrice implements BaseEntity {
	
	private Long id;
	private Long displayId;
	private Double price;
	private SeatType seatType;
}
