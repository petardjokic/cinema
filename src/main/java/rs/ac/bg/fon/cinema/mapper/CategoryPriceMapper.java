package rs.ac.bg.fon.cinema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.CategoryPrice;

@Mapper
public interface CategoryPriceMapper extends BaseMapper<CategoryPrice> {

	public CategoryPrice getById(Long id);

	public int insert(CategoryPrice entity);

	public int update(CategoryPrice entity);

	public int deleteById(Long id);

	public List<CategoryPrice> getByCategoryId(Long categoryId);
}
