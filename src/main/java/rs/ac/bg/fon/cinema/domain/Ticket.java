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
public class Ticket implements BaseEntity {
	private Long id;
	private Long receiptId;
	private Long displayId;
	private Long seatId;
	private Boolean active;

	@Override
	public String toString() {
		return "ID: " + id + " DISP.ID: " + displayId + " SEAT.ID: " + seatId;
	}
}
