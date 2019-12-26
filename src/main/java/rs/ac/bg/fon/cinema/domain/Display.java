package rs.ac.bg.fon.cinema.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Display implements BaseEntity {

	private Long id;
	private Long movieId;
	private Long hallId;
	private LocalDateTime startsAt;
}
