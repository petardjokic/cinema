package rs.ac.bg.fon.cinema.mapper.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.ProductionCompany;
import rs.ac.bg.fon.cinema.mapper.ProductionCompanyMapper;

@Component
@Slf4j
public class ProductionCompanySetup {
	
	@Autowired
	private ProductionCompanyMapper ProductionCompanyMapper;
	
	private ProductionCompany saveProductionCompany(String name) {
		ProductionCompany productionCompany = ProductionCompany.builder().name(name).build();
		ProductionCompanyMapper.save(productionCompany);
		log.info("Production company {} saved!", productionCompany);
		return productionCompany;
	}
	
	public ProductionCompany productionCompanyFirstPC() {
		return saveProductionCompany("FirstPC");
	}
	
	public ProductionCompany productionCompanySecondPC() {
		return saveProductionCompany("SecondPC");
	}
	
	public ProductionCompany productionCompanyThirdPC() {
		return saveProductionCompany("ThirdPC");
	}

}
