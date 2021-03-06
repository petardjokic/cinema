package rs.ac.bg.fon.cinema.service;

import java.util.List;

import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.ProductionCompany;


public interface ProductionCompanyService {

	public ProductionCompany getProductionCompanyById(Long prodCompanyId);

	public List<ProductionCompany> getAllProductionCompanies();
	
	public List<ProductionCompany> getProductionCompaniesByMovieId(Long movieId);
	
	public void saveMovieProductionCompanies(Movie movies);
	
	public ProductionCompany save(ProductionCompany productionCompany);
}
