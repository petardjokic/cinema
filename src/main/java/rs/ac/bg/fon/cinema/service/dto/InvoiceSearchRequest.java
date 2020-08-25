package rs.ac.bg.fon.cinema.service.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class InvoiceSearchRequest {
	
	private Long invoiceId;
	private LocalDate dateFrom;
	private LocalDate dateTo;
}
