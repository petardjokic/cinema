package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.domain.DisplayPrice;

public interface DisplayPriceService {

	public DisplayPrice getById(Long id);

	public List<DisplayPrice> getByDisplayId(Long displayId);
	
	public DisplayPrice saveDisplayPrice(DisplayPrice displayPrice);
	
	public int deleteDisplayPrice(Long id);
}
