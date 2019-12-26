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
public class HallSeat implements BaseEntity {

	private Long id;
	private Long hallId;
	private Long seatTypeId;
	private int row;
	private int column;

	@Override
	public String toString() {
		return "ID: " + id + " HALL.ID: " + hallId + " TYPE.ID: " + seatTypeId + " ROW: " + row + " COL: " + column;
	}

}
