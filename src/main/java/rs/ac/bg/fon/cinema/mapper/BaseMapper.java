package rs.ac.bg.fon.cinema.mapper;

public interface BaseMapper<E> {
	
	public Long count();
	
	public E getById(Long id);

	public int insert(E entity);

	public int update(E entity);

	public int deleteById(Long id);
}
