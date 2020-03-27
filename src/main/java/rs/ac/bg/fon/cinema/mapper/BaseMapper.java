package rs.ac.bg.fon.cinema.mapper;

import java.util.List;

import rs.ac.bg.fon.cinema.domain.BaseEntity;

public interface BaseMapper<E extends BaseEntity> {

	public Long count();

	public E getById(Long id);
	
	public List<E> getAll();
	
	public int insert(E entity);

	public int update(E entity);

	public int deleteById(Long id);

	public default E save(E entity) {
		if (entity.getId() == null) {
			insert(entity);
		} else {
			update(entity);
		}
		return getById(entity.getId());
	}
}
