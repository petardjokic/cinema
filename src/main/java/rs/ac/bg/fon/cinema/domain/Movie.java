package rs.ac.bg.fon.cinema.domain;

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
public class Movie implements BaseEntity {
	
	private Long id;
	private String title;
	private String trailerUri;
	private String description;
	private int duration;
	private int releaseYear;
	private List<MovieGenre> genres;
	private List<MovieProductionCompany> productionCompanies;
}
