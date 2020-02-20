package rs.ac.bg.fon.cinema.domain;

import java.math.BigDecimal;

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
public class DisplayPrice implements BaseEntity {
	private Long id;
	private Long displayId;
	private Long seatTypeId;
	private String seatTypeName;
	private BigDecimal price;
}
