package ceu.dam.ad.users.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.users.api.request.ChangePasswordRequest;
import ceu.dam.ad.users.api.request.CreateUserRequest;
import ceu.dam.ad.users.model.User;
import ceu.dam.ad.users.service.DuplicateUserException;
import ceu.dam.ad.users.service.UserException;
import ceu.dam.ad.users.service.UserNotFoundException;
import ceu.dam.ad.users.service.UserService;
import ceu.dam.ad.users.service.UserUnauthorizedException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@SecurityRequirement(name = "Authorization")
public class UserServiceApi {

	@Autowired
	private UserService service;
	
	
	@PostMapping
	@Operation(summary = "Crear usuario", description = "Crea un nuevo usuario en el sistema generando automáticamente el ID")
	public User createUser(@RequestBody @Valid CreateUserRequest request) throws DuplicateUserException, UserException{
		User user = new User();
		ModelMapper mapper = new ModelMapper();
		mapper.map(request, user);
		return service.createUser(user);
	}
	
	@PutMapping
	@Operation(summary = "Cambiar password", description = "Cambia la password del usuario. Tanto la password antigua como la nueva se deben enviar en claro")
	public void changePassword(@RequestBody @Valid ChangePasswordRequest request) throws UserNotFoundException, UserUnauthorizedException, UserException{
		service.changePassword(request.getIdUser(), request.getOldPassword(), request.getNewPassword());
	}
	
	@GetMapping
	@Operation(summary = "Login usuario", description = "Realiza login en el sistema a partir del username o email del usuario. La password se debe enviar en claro")
	public User login(@RequestParam String login, @RequestParam String password) throws UserNotFoundException, UserUnauthorizedException, UserException{
		return service.login(login, password);
	}
	
	@GetMapping("/{idUser}")
	@Operation(summary = "Consultar usuario", description = "Consulta un usuario a partir de su identificador")
	public User getUser(@PathVariable Long idUser) throws UserNotFoundException, UserException{
		return service.getUser(idUser);
	}
	
}
