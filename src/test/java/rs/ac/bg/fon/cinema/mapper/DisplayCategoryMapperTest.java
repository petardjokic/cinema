package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.DisplayCategory;

@Slf4j
class DisplayCategoryMapperTest extends BaseMapperTest{

	@Autowired
	private DisplayCategoryMapper displayCategoryMapper;

	@Test
	void testCRUD() {

		log.info("Adding a new category");
		DisplayCategory category = DisplayCategory.builder().name("Premiere").build();
		assertEquals(1, displayCategoryMapper.insert(category));
		
		log.info("Getting category");
		DisplayCategory categoryDb = displayCategoryMapper.getById(category.getId());
		assertEquals(category.getId(), categoryDb.getId());
		assertEquals(category.getName(), categoryDb.getName());
		
		log.info("Updating category");
		category.setName("Category");
		assertEquals(1, displayCategoryMapper.update(category));
		
		log.info("Getting category");
		categoryDb = displayCategoryMapper.getById(category.getId());
		assertEquals(category.getId(), categoryDb.getId());
		assertEquals(category.getName(), categoryDb.getName());
		
		log.info("Deleting category");
		assertEquals(1, displayCategoryMapper.deleteById(category.getId()));
		
	}

}
