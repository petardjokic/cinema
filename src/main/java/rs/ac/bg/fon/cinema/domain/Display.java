package rs.ac.bg.fon.cinema.domain;

import java.time.LocalDateTime;
import java.util.List;

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
public class Display implements BaseEntity {

	private Long id;
	private LocalDateTime startsAt;
	private Boolean active;
	private DisplayCategory category;
	private Movie movie;
	private Hall hall;
	private List<Ticket> tickets;
}
