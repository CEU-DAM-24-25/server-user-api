package ceu.dam.ad.users.api.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ceu.dam.ad.users.service.DuplicateUserException;

@ControllerAdvice
public class DuplicateExceptionHandler {

	@ExceptionHandler(DuplicateUserException.class)
	public ResponseEntity<String> handle(DuplicateUserException e){
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	
	
}
