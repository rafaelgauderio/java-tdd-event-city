package com.devsuperior.bds02.controllers.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private Instant timestamp;
	private String error;
	private String message;
	private String path;
	
	public StandardError () {
		
	}

	public StandardError(Integer status, Instant timestamp, String error, String message, String path) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
