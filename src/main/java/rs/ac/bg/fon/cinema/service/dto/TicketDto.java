package rs.ac.bg.fon.cinema.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class TicketDto {

	private Long id;
	private Long displayId;
	private String movieTitle;
	private String hallName;
}
