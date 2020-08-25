package rs.ac.bg.fon.cinema.service.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class DisplaySearchRequest {
	
	private Long movieId;
	private String movieTitle;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	
}
