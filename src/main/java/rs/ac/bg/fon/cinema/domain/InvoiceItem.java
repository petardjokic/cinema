package rs.ac.bg.fon.cinema.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class InvoiceItem implements BaseEntity{
	
	private Long id;
	private Long invoiceId;
	private Long displayId;
	private Seat seat;
	private Boolean active;
	private Double price;
}
