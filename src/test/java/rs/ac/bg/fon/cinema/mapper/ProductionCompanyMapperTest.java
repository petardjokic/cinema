package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.ProductionCompany;

@Slf4j
class ProductionCompanyMapperTest extends BaseMapperTest {

	@Autowired
	private ProductionCompanyMapper productionCompanyMapper;

	@Test
	void testCRUD() {

		log.info("Adding a new prod comp");
		ProductionCompany prodComp = ProductionCompany.builder().name("KProd").build();
		assertEquals(1, productionCompanyMapper.insert(prodComp));

		log.info("Getting prod comp");
		ProductionCompany prodCompDb = productionCompanyMapper.getById(prodComp.getId());
		assertEquals(prodComp.getId(), prodCompDb.getId());
		assertEquals(prodComp.getName(), prodCompDb.getName());

		log.info("Updating prod comp");
		prodComp.setName("Prod");
		assertEquals(1, productionCompanyMapper.update(prodComp));

		log.info("Getting genre");
		prodCompDb = productionCompanyMapper.getById(prodComp.getId());
		assertEquals(prodComp.getId(), prodCompDb.getId());
		assertEquals(prodComp.getName(), prodCompDb.getName());

		log.info("Deleting genre");
		assertEquals(1, productionCompanyMapper.deleteById(prodComp.getId()));

	}

}
