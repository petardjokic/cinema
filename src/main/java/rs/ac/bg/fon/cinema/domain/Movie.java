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
public class Movie implements BaseEntity {
	private Long id;
	private String title;
	private String description;
	private int duration;
	private int releaseYear;
}
