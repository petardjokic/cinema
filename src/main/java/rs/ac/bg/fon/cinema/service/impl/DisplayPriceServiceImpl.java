package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public DisplayPrice saveDisplayPrice(DisplayPrice displayPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteDisplayPrice(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
