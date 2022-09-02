package com.devsuperior.bds02.controllers.exceptions;

import java.time.Instant;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException error, HttpServletRequest request) {
		StandardError erro = new StandardError ();
		erro.setTimestamp(Instant.now());
		erro.setStatus(HttpStatus.NOT_FOUND.value());
		erro.setError("Recurso não foi encontrado!");
		erro.setMessage(error.getMessage());
		erro.setPath(request.getRequestURI());				
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}
