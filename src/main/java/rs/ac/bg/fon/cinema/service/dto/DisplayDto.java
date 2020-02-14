package rs.ac.bg.fon.cinema.service.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import rs.ac.bg.fon.cinema.domain.DisplayPrice;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class DisplayDto {
	
	private Long id;
	private MovieDto movie;
	private HallDto hall;
	private List<DisplayPrice> displayPrices;
	private LocalDateTime startsAt;
	private LocalDateTime endsAt;
}
