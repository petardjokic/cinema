package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.MovieProductionCompany;
import rs.ac.bg.fon.cinema.domain.ProductionCompany;
import rs.ac.bg.fon.cinema.mapper.setup.MovieSetup;
import rs.ac.bg.fon.cinema.mapper.setup.ProductionCompanySetup;

@Slf4j
class MovieProductionCompanyMapperTest extends BaseMapperTest {

	@Autowired
	private MovieProductionCompanyMapper movieProdCompMapper;

	@Autowired
	private MovieSetup movieSetup;
	
	@Autowired
	private ProductionCompanySetup productionCompanySetup;
	
	@Test
	void testCRUD() {

		ProductionCompany prodComp1 = productionCompanySetup.productionCompanyFirstPC();
		ProductionCompany prodComp2 = productionCompanySetup.productionCompanySecondPC();
		
		Movie movie1 = movieSetup.movieBasicInstinct();
		Movie movie2 = movieSetup.moviePulpFiction();
		
		log.info("Adding a new movie prod comp");
		MovieProductionCompany movieProdComp = MovieProductionCompany.builder().movieId(movie1.getId()).build();
		assertEquals(1, movieProdCompMapper.insert(movieProdComp));
		
		log.info("Getting movie prod comp");
		MovieProductionCompany movieProdCompDb = movieProdCompMapper.getById(movieProdComp.getId());
		assertEquals(movieProdComp.getId(), movieProdCompDb.getId());
		assertEquals(movieProdComp.getMovieId(), movieProdCompDb.getMovieId());
//		assertEquals(movieProdComp.getProductionCompanyId(), movieProdCompDb.getProductionCompanyId());
		
		log.info("Updating movie prod comp");
		movieProdComp.setMovieId(movie2.getId());
//		movieProdComp.setProductionCompanyId(prodComp2.getId());
		assertEquals(1, movieProdCompMapper.update(movieProdComp));
		
		log.info("Getting movie prod comp");
		movieProdCompDb = movieProdCompMapper.getById(movieProdComp.getId());
		assertEquals(movieProdComp.getId(), movieProdCompDb.getId());
		assertEquals(movieProdComp.getMovieId(), movieProdCompDb.getMovieId());
//		assertEquals(movieProdComp.getProductionCompanyId(), movieProdCompDb.getProductionCompanyId());
		
		log.info("Deleting prod comp");
		assertEquals(1, movieProdCompMapper.deleteById(movieProdComp.getId()));
		
	}

}
