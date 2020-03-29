package rs.ac.bg.fon.cinema.domain;

import java.time.LocalDateTime;
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
public class InvoiceDto {
	
	private Long id;
	private LocalDateTime issuedAt;
	private Boolean active;
	private List<Display> events;

}
