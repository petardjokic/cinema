package rs.ac.bg.fon.cinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.cinema.domain.ProductionCompany;
import rs.ac.bg.fon.cinema.service.ProductionCompanyService;

@RestController
@CrossOrigin
@RequestMapping(path = "api/productionCompanies")
public class ProductionCompanyApi {
	
	@Autowired
	private ProductionCompanyService productionCompanyService;
	
	@GetMapping
	public List<ProductionCompany> getAllProductionCompanies() {
	return productionCompanyService.getAllProductionCompanies();
	}
	

}
