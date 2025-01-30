package ceu.dam.ad.users.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChangePasswordRequest {
	
	@NotNull
	@Schema(description =  "Id usuario al que se desea cambiar el password")
	private Long idUser;
	@NotBlank
	@Schema(description =  "Password actual. Se debe enviar sin codificar.")
	private String oldPassword;
	@NotBlank
	@Size(min = 8)
	@Schema(description =  "Password nueva. Mínimo 8 caracteres. Se debe enviar sin codificar.")
	private String newPassword;
	
	
}
