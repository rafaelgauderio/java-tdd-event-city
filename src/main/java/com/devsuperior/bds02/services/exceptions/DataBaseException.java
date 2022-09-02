package com.devsuperior.bds02.services.exceptions;

public class DataBaseException extends RuntimeException{

	// se tentar excluir um Cidade que já tem um evento nela tem que 
	// dar erro de integridade relacional
	
	private static final long serialVersionUID = 1L;
	
	public DataBaseException(String message) {
		super(message);
	}

}
