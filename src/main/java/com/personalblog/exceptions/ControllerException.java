package com.personalblog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.personalblog.handlers.ObjectNotFoundHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerException {
	
	@ExceptionHandler(ObjectNotFoundHandler.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundHandler objectNotFoundHandler, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), objectNotFoundHandler.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
