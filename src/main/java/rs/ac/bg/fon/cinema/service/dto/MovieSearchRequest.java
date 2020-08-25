package rs.ac.bg.fon.cinema.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class MovieSearchRequest {
	private String title;
}
