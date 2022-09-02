package com.devsuperior.bds02.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.bds02.services.exceptions.DataBaseException;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException error, HttpServletRequest request) {
		StandardError erro = new StandardError ();
		erro.setTimestamp(Instant.now());
		erro.setStatus(HttpStatus.NOT_FOUND.value()); //codigo 404
		erro.setError("Recurso não foi encontrado!");
		erro.setMessage(error.getMessage());
		erro.setPath(request.getRequestURI());				
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> database(DataBaseException error, HttpServletRequest request) {
		StandardError erro = new StandardError();
		HttpStatus status = HttpStatus.BAD_REQUEST; //codigo 400
		erro.setTimestamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Exceção de dataBase. Erro de integridade Relacional.");
		erro.setMessage(error.getMessage());
		erro.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
		
	}
	
	

}
