package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.cinema.domain.CategoryPrice;
import rs.ac.bg.fon.cinema.domain.DisplayCategory;
import rs.ac.bg.fon.cinema.mapper.CategoryPriceMapper;
import rs.ac.bg.fon.cinema.mapper.DisplayCategoryMapper;
import rs.ac.bg.fon.cinema.service.DisplayCategoryService;

@Service
public class DisplayCategoryServiceImpl implements DisplayCategoryService {
	
	@Autowired
	private DisplayCategoryMapper displayCategoryMapper;

	@Autowired
	private CategoryPriceMapper priceMapper;

	@Override
	public DisplayCategory getById(Long id) {
		DisplayCategory categoryDb = displayCategoryMapper.getById(id);
		Optional.ofNullable(categoryDb)
			.ifPresent(category -> category.setPrices(getPricesForCategory(category.getId())));
		return categoryDb;
	}

	@Override
	public List<DisplayCategory> getAll() {
		List<DisplayCategory> categories = displayCategoryMapper.getAll();
		categories.stream().forEach(category -> {
			category.setPrices(getPricesForCategory(category.getId()));
		});
		return categories;
	}

	public List<CategoryPrice> getPricesForCategory(Long categoryId) {
		return priceMapper.getByCategoryId(categoryId);
	}

}
