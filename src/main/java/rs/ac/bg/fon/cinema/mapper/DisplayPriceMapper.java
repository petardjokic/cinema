package rs.ac.bg.fon.cinema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.DisplayPrice;

@Mapper
public interface DisplayPriceMapper extends BaseMapper<DisplayPrice> {
	public Long count();

	public DisplayPrice getById(Long id);

	public int insert(DisplayPrice entity);

	public int update(DisplayPrice entity);

	public int deleteById(Long id);
	
	public List<DisplayPrice> getByDisplayId(Long displayId);
}
