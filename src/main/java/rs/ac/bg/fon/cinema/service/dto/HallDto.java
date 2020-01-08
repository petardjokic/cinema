package rs.ac.bg.fon.cinema.service.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class HallDto {
	
	private Long id;
	private String name;
	private List<HallSeatDto> seats; 
}
