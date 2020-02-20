package rs.ac.bg.fon.cinema.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Genre implements BaseEntity {
	@EqualsAndHashCode.Include
	private Long id;
	@EqualsAndHashCode.Exclude
	private String name;
}
