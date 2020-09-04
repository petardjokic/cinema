package rs.ac.bg.fon.cinema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import rs.ac.bg.fon.cinema.domain.User;
import rs.ac.bg.fon.cinema.service.dto.UserSearchRequest;

@Mapper
public interface UserMapper extends BaseMapper<User> {

	public User getById(Long id);
	
	public List<User> getAll();
	
	public int insert(User entity);

	public int update(User entity);

	public int deleteById(Long id);
	
	public List<User> search(UserSearchRequest request);
}
