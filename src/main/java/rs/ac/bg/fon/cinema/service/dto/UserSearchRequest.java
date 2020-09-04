package rs.ac.bg.fon.cinema.service.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuperBuilder
public class UserSearchRequest {
	
	private String username;
	private String password;
}
