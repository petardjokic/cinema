package rs.ac.bg.fon.cinema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.DisplayCategory;

@Mapper
public interface DisplayCategoryMapper extends BaseMapper<DisplayCategory> {
	
	public DisplayCategory getById(Long id);
	
	public List<DisplayCategory> getAll();
	
	public int insert(DisplayCategory entity);

	public int update(DisplayCategory entity);

	public int deleteById(Long id);
}
