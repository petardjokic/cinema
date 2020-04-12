package rs.ac.bg.fon.cinema.mapper.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.DisplayCategory;
import rs.ac.bg.fon.cinema.mapper.DisplayCategoryMapper;

@Component
@Slf4j
public class DisplayCategorySetup {
	
	@Autowired
	private DisplayCategoryMapper DisplayCategoryMapper;
	
	private DisplayCategory saveDisplayCategory(String name) {
		DisplayCategory displayCategory = DisplayCategory.builder().name(name).build();
		DisplayCategoryMapper.save(displayCategory);
		log.info("Display Category {} saved!", displayCategory);
		return displayCategory;
	}
	
	public DisplayCategory displayCategoryPremiereBlockbuster() {
		return saveDisplayCategory("Premiere Blockbuster");
	}
	
	public DisplayCategory displayCategoryPremiere() {
		return saveDisplayCategory("Premiere");
	}
	
	public DisplayCategory displayCategoryRegular() {
		return saveDisplayCategory("Regular");
	}
}
