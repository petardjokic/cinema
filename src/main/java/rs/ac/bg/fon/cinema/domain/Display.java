package rs.ac.bg.fon.cinema.domain;

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
public class Display implements BaseEntity {

	private Long id;
	private Long movieId;
	private Long hallId;
	private LocalDateTime startsAt;
	private LocalDateTime endsAt;
	
}
