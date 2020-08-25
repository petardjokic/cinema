package rs.ac.bg.fon.cinema.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User {

	public Long id;
	public String username;
	public String password;
	public String name;
	
}
