package rs.ac.bg.fon.cinema.mapper;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.ProductionCompany;

@Mapper
public interface ProductionCompanyMapper extends BaseMapper<ProductionCompany>{
	
	public Long count();
	
	public ProductionCompany getById(Long id);

	public int insert(ProductionCompany entity);

	public int update(ProductionCompany entity);

	public int deleteById(Long id);
	
}
