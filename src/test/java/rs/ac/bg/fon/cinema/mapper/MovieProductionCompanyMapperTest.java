package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.MovieProductionCompany;
import rs.ac.bg.fon.cinema.domain.ProductionCompany;

@Slf4j
class MovieProductionCompanyMapperTest extends BaseMapperTest {

	@Autowired
	private MovieProductionCompanyMapper movieProdCompMapper;

	@Autowired
	private MovieMapper movieMapper;
	
	@Autowired
	private ProductionCompanyMapper prodCompMapper;
	
	@Test
	void testCRUD() {
		assertEquals(0L, movieProdCompMapper.count());

		log.info("Adding a new prod comp 1");
		ProductionCompany prodComp = ProductionCompany.builder().name("Prod1").build();
		prodCompMapper.insert(prodComp);
		
		log.info("Adding a new prod comp 2");
		ProductionCompany prodComp2 = ProductionCompany.builder().name("Prod2").build();
		prodCompMapper.insert(prodComp2);
		
		log.info("Adding a new movie 1");
		Movie movie = Movie.builder().title("Trainspotting").description("Desc").duration(134).releaseYear(1996).build();
		movieMapper.insert(movie);
		
		log.info("Adding a new movie 2");
		Movie movie2 = Movie.builder().title("Trainspotting2").description("Desc2").duration(1341).releaseYear(11996).build();
		movieMapper.insert(movie2);
		
		log.info("Adding a new movie prod comp");
		MovieProductionCompany movieProdComp = MovieProductionCompany.builder().movieId(movie.getId()).productionCompanyId(prodComp.getId()).build();
		assertEquals(1, movieProdCompMapper.insert(movieProdComp));
		
		log.info("Getting movie prod comp");
		MovieProductionCompany movieProdCompDb = movieProdCompMapper.getById(movieProdComp.getId());
		assertEquals(movieProdComp.getId(), movieProdCompDb.getId());
		assertEquals(movieProdComp.getMovieId(), movieProdCompDb.getMovieId());
		assertEquals(movieProdComp.getProductionCompanyId(), movieProdCompDb.getProductionCompanyId());
		
		log.info("Updating movie prod comp");
		movieProdComp.setMovieId(movie2.getId());
		movieProdComp.setProductionCompanyId(prodComp2.getId());
		assertEquals(1, movieProdCompMapper.update(movieProdComp));
		
		log.info("Getting movie prod comp");
		movieProdCompDb = movieProdCompMapper.getById(movieProdComp.getId());
		assertEquals(movieProdComp.getId(), movieProdCompDb.getId());
		assertEquals(movieProdComp.getMovieId(), movieProdCompDb.getMovieId());
		assertEquals(movieProdComp.getProductionCompanyId(), movieProdCompDb.getProductionCompanyId());
		
		log.info("Deleting prod comp");
		assertEquals(1, movieProdCompMapper.deleteById(movieProdComp.getId()));
		
		assertEquals(0, movieProdCompMapper.count());

	}

}
