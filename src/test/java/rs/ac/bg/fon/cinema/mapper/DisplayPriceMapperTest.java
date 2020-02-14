package rs.ac.bg.fon.cinema.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import rs.ac.bg.fon.cinema.domain.Display;
import rs.ac.bg.fon.cinema.domain.DisplayPrice;
import rs.ac.bg.fon.cinema.domain.Hall;
import rs.ac.bg.fon.cinema.domain.Movie;
import rs.ac.bg.fon.cinema.domain.SeatType;

@Slf4j
class DisplayPriceMapperTest extends BaseMapperTest{

	@Autowired
	private DisplayPriceMapper displayPriceMapper;
	
	@Autowired
	private DisplayMapper displayMapper;
	
	@Autowired
	private SeatTypeMapper seatTypeMapper;
	
	@Autowired
	private MovieMapper movieMapper;
	
	@Autowired
	private HallMapper hallMapper;

	@Test
	void testCRUD() {
		assertEquals(0L, displayPriceMapper.count());
		
		log.info("Adding a new hall");
		Hall hall = Hall.builder().name("Kings Hall").build();
		hallMapper.insert(hall);
		
		log.info("Adding a new movie");
		Movie movie = Movie.builder().title("Trainspotting").description("Desc").duration(134).releaseYear(1996).build();
		movieMapper.insert(movie);
		
		log.info("Adding a new display");
		LocalDateTime startsAt =LocalDateTime.now();
		Display display = Display.builder().movieId(movie.getId()).hallId(hall.getId()).startsAt(startsAt).endsAt(startsAt.plusMinutes(movie.getDuration())).build();
		assertEquals(1, displayMapper.insert(display));
		
		log.info("Adding a new seat type");
		SeatType seatType1 = SeatType.builder().name("Classic").build();
		seatTypeMapper.insert(seatType1);
		
		log.info("Adding a new display price");
		DisplayPrice displayPrice = DisplayPrice.builder().displayId(display.getId()).seatTypeId(seatType1.getId()).price(new BigDecimal(100)).build();
		assertEquals(1, displayPriceMapper.insert(displayPrice));
		
		log.info("Getting display price");
		DisplayPrice displayPriceDb = displayPriceMapper.getById(displayPrice.getId());
		assertEquals(displayPrice.getId(), displayPriceDb.getId());
		assertEquals(displayPrice.getDisplayId(), displayPriceDb.getDisplayId());
		assertEquals(displayPrice.getSeatTypeId(), displayPriceDb.getSeatTypeId());
		assertEquals(displayPrice.getPrice(), displayPriceDb.getPrice());
		
		log.info("Updating hall seat");
		displayPrice.setPrice(new BigDecimal(150));
		assertEquals(1, displayPriceMapper.update(displayPrice));
		
		log.info("Getting hall seat");
		displayPriceDb = displayPriceMapper.getById(displayPrice.getId());
		assertEquals(displayPrice.getId(), displayPriceDb.getId());
		assertEquals(displayPrice.getDisplayId(), displayPriceDb.getDisplayId());
		assertEquals(displayPrice.getSeatTypeId(), displayPriceDb.getSeatTypeId());
		assertEquals(displayPrice.getPrice(), displayPriceDb.getPrice());
		
		log.info("Deleting hall seat");
		assertEquals(1, displayPriceMapper.deleteById(displayPrice.getId()));
		
		assertEquals(0, displayPriceMapper.count());
	}
	

}
