package rs.ac.bg.fon.cinema.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode
public class MovieProductionCompany implements BaseEntity {
	@EqualsAndHashCode.Exclude
	private Long id;
	@EqualsAndHashCode.Include
	private Long movieId;
	@EqualsAndHashCode.Include
	private Long productionCompanyId;

}
