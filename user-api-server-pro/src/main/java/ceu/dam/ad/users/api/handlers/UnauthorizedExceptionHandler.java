package ceu.dam.ad.users.api.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ceu.dam.ad.users.service.UserUnauthorizedException;

@ControllerAdvice
public class UnauthorizedExceptionHandler {

	@ExceptionHandler(UserUnauthorizedException.class)
	public ResponseEntity<String> handle(UserUnauthorizedException e){
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(e.getMessage());
	}
	
	
}
