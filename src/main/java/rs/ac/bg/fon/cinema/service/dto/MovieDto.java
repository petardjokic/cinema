package rs.ac.bg.fon.cinema.service.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import rs.ac.bg.fon.cinema.domain.Genre;
import rs.ac.bg.fon.cinema.domain.ProductionCompany;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class MovieDto {
	private Long id;
	private String title;
	private String description;
	private int duration;
	private int releaseYear;
	private List<Genre> genres;
	private List<ProductionCompany> productionCompanies;
}
