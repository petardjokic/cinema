package rs.ac.bg.fon.cinema.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Cart {
	private List<CartItem> cartItemsUnchecked;
	private List<CartItem> cartItemsChecked;
	private InvoiceDto invoice;
	
	public Cart() {
		cartItemsUnchecked = new ArrayList<>();
		cartItemsChecked = new ArrayList<>();
	}
}
