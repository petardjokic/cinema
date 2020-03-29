package rs.ac.bg.fon.cinema.domain;

import java.time.LocalDateTime;
import java.util.List;

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
public class Display implements BaseEntity {

	private Long id;
	private LocalDateTime startsAt;
	private Movie movie;
	private Hall hall;
	private List<DisplayPrice> prices;
	private List<Ticket> tickets;
	private List<SeatAvailability> seatsAvailability;
	
}
