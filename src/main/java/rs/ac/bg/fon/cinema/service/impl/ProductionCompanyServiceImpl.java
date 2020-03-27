package rs.ac.bg.fon.cinema.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.MovieProductionCompany;
import rs.ac.bg.fon.cinema.domain.ProductionCompany;
import rs.ac.bg.fon.cinema.mapper.MovieProductionCompanyMapper;
import rs.ac.bg.fon.cinema.mapper.ProductionCompanyMapper;
import rs.ac.bg.fon.cinema.service.ProductionCompanyService;

@Service
@Slf4j
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
	public void saveMovieProductionCompanies(Movie movie) {
		List<MovieProductionCompany> movieProductionCompaniesDb = movieProductionCompanyMapper.getByMovieId(movie.getId());
		
		List<MovieProductionCompany> movieProductionCompaniesParam = movie.getProductionCompanies().stream()
				.map(productionCompany -> new MovieProductionCompany(null, movie.getId(), productionCompany.getId()))
				.collect(Collectors.toList());

		log.info("Deleting removed movie production companies");
		movieProductionCompaniesDb.stream()
				.filter(movieProductionCompanyDb -> !movieProductionCompaniesParam.contains(movieProductionCompanyDb))
				.forEach(movieProductionCompany -> movieProductionCompanyMapper.deleteById(movieProductionCompany.getId()));
		
		log.info("Saving added movie production companies");
		 movieProductionCompaniesParam.stream()
				.filter(productionCompany -> !movieProductionCompaniesDb.contains(productionCompany))
				.forEach(movieProductionCompany -> movieProductionCompanyMapper.save(movieProductionCompany));
	}

	@Override
	@Transactional
	public ProductionCompany save(ProductionCompany productionCompany) {
		return productionCompanyMapper.save(productionCompany);
	}

}
