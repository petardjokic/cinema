package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.cinema.domain.DisplayPrice;
import rs.ac.bg.fon.cinema.mapper.DisplayPriceMapper;
import rs.ac.bg.fon.cinema.service.DisplayPriceService;

@Service
public class DisplayPriceServiceImpl implements DisplayPriceService {

	@Autowired
	private DisplayPriceMapper displayPriceMapper;

	@Override
	public DisplayPrice getById(Long id) {
		return displayPriceMapper.getById(id);
	}

	@Override
	public List<DisplayPrice> getByDisplayId(Long displayId) {
		return displayPriceMapper.getByDisplayId(displayId);
	}

	@Override
	@Transactional
	public DisplayPrice saveDisplayPrice(DisplayPrice displayPrice) {
		return displayPriceMapper.save(displayPrice);
	}

	@Override
	public int deleteDisplayPrice(Long id) {
		return displayPriceMapper.deleteById(id);
	}

	@Override
	public void saveDisplayPriceForDisplay(Long displayId, List<DisplayPrice> displayPrices) {
		displayPrices.stream().forEach(price -> {
			price.setDisplayId(displayId);
			displayPriceMapper.save(price);
		});
	}

}
