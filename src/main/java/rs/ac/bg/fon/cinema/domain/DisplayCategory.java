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
@Setter
@Getter
@SuperBuilder
@ToString
public class DisplayCategory implements BaseEntity {
	
	private Long id;
	private String name;
	private List<CategoryPrice> prices;
}
