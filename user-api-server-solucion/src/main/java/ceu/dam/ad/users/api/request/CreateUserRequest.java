package ceu.dam.ad.users.api.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUserRequest {
	
	@NotBlank
	@Size(min = 6, max = 50)
	private String username;
	@Email
	@NotBlank
	@Size(max = 50)
	private String email;
	@NotBlank
	@Size(min = 8)
	private String password;
	
	
}
