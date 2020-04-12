package rs.ac.bg.fon.cinema.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
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
public class Genre implements BaseEntity {
	@EqualsAndHashCode.Include
	private Long id;
	@EqualsAndHashCode.Exclude
	private String name;
}
