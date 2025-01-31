package ceu.dam.ad.users.api.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ceu.dam.ad.users.service.UserNotFoundException;

@ControllerAdvice
public class NotFoundExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handle(UserNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(e.getMessage());
	}
	
	
}
