package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.cinema.domain.MovieProductionCompany;
import rs.ac.bg.fon.cinema.domain.ProductionCompany;
import rs.ac.bg.fon.cinema.mapper.MovieProductionCompanyMapper;
import rs.ac.bg.fon.cinema.mapper.ProductionCompanyMapper;
import rs.ac.bg.fon.cinema.service.ProductionCompanyService;

@Service
public class ProductionCompanyServiceImpl implements ProductionCompanyService {

	@Autowired
	private ProductionCompanyMapper productionCompanyMapper;

	@Autowired
	private MovieProductionCompanyMapper movieProductionCompanyMapper;

	@Override
	public ProductionCompany getProductionCompanyById(Long prodCompanyId) {
		return productionCompanyMapper.getById(prodCompanyId);
	}

	@Override
	public List<ProductionCompany> getAllProductionCompanies() {
		return productionCompanyMapper.getAll();
	}

	@Override
	public List<ProductionCompany> getProductionCompaniesByMovieId(Long movieId) {
		List<MovieProductionCompany> movieProductionCompanies = movieProductionCompanyMapper.getByMovieId(movieId);
		return movieProductionCompanies.stream().map(movieProductionCompany -> {
			return productionCompanyMapper.getById(movieProductionCompany.getProductionCompanyId());
		}).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void saveMovieProductionCompanies(Long movieId, List<ProductionCompany> productionCompanies) {
		List<ProductionCompany> movieProductionCompaniesDb = getProductionCompaniesByMovieId(movieId);
		List<ProductionCompany> productionCompaniesToDelete = movieProductionCompaniesDb.stream().filter(productionCompanyDb -> !productionCompanies.contains(productionCompanyDb)).collect(Collectors.toList());
		List<ProductionCompany> productionCompaniesToAdd = productionCompanies.stream().filter(productionCompany -> !movieProductionCompaniesDb.contains(productionCompany)).collect(Collectors.toList());
		productionCompaniesToDelete.stream().forEach(productionCompany -> {
			MovieProductionCompany movieProductionCompany = convertToMovieProductionCompany(movieId, productionCompany);
			movieProductionCompanyMapper.deleteMovieProductionCompany(movieProductionCompany);
		});
		productionCompaniesToAdd.stream().forEach(productionCompany -> {
			MovieProductionCompany movieProductionCompany = convertToMovieProductionCompany(movieId, productionCompany);
			movieProductionCompanyMapper.save(movieProductionCompany);
		});
	}

	private MovieProductionCompany convertToMovieProductionCompany(Long movieId, ProductionCompany productionCompany) {
		return MovieProductionCompany.builder().movieId(movieId).productionCompanyId(productionCompany.getId()).build();
	}

}
