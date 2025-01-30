package ceu.dam.ad.users.api.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ceu.dam.ad.users.service.UserException;

@ControllerAdvice
public class UserErrorExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<String> handle(UserException e){
		return ResponseEntity.internalServerError().body(e.getMessage());
	}
	
	
}
