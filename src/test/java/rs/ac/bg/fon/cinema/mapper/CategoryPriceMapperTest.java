package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.DisplayCategory;
import rs.ac.bg.fon.cinema.domain.CategoryPrice;
import rs.ac.bg.fon.cinema.domain.SeatType;
import rs.ac.bg.fon.cinema.mapper.setup.DisplayCategorySetup;
import rs.ac.bg.fon.cinema.mapper.setup.SeatTypeSetup;

@Slf4j
class CategoryPriceMapperTest extends BaseMapperTest{

	@Autowired
	private CategoryPriceMapper categoryPriceMapper;
	
	@Autowired
	private DisplayCategorySetup displayCategorySetup;
	
	@Autowired
	private SeatTypeSetup seatTypeSetup;
	

	@Test
	void testCRUD() {
		DisplayCategory category1 = displayCategorySetup.displayCategoryPremiere();
		DisplayCategory category2 = displayCategorySetup.displayCategoryPremiereBlockbuster();
		
		SeatType seatType1 = seatTypeSetup.seatTypeClassic();
		SeatType seatType2 = seatTypeSetup.seatTypeLove();
		
		log.info("Adding a new category price");
		CategoryPrice categoryPrice = CategoryPrice.builder()
				.displayCategoryId(category1.getId())
				.seatType(seatType1)
				.price(new Double(100)).build();
		assertEquals(1, categoryPriceMapper.insert(categoryPrice));
		
		log.info("Getting category price");
		CategoryPrice categoryPriceDb = categoryPriceMapper.getById(categoryPrice.getId());
		assertEquals(categoryPrice.getId(), categoryPriceDb.getId());
		assertEquals(categoryPrice.getDisplayCategoryId(), categoryPriceDb.getDisplayCategoryId());
		assertEquals(categoryPrice.getSeatType().getId(), categoryPriceDb.getSeatType().getId());
		assertEquals(categoryPrice.getSeatType().getName(), categoryPriceDb.getSeatType().getName());
		assertEquals(categoryPrice.getPrice(), categoryPriceDb.getPrice());
		
		log.info("Updating category");
		categoryPrice.setDisplayCategoryId(category2.getId());
		categoryPrice.setSeatType(seatType2);
		categoryPrice.setPrice(new Double(150));
		assertEquals(1, categoryPriceMapper.update(categoryPrice));
		
		log.info("Getting category");
		categoryPriceDb = categoryPriceMapper.getById(categoryPrice.getId());
		assertEquals(categoryPrice.getId(), categoryPriceDb.getId());
		assertEquals(categoryPrice.getDisplayCategoryId(), categoryPriceDb.getDisplayCategoryId());
		assertEquals(categoryPrice.getSeatType().getId(), categoryPriceDb.getSeatType().getId());
		assertEquals(categoryPrice.getPrice(), categoryPriceDb.getPrice());
		
		log.info("Deleting category");
		assertEquals(1, categoryPriceMapper.deleteById(categoryPrice.getId()));
		
	}
	

}
