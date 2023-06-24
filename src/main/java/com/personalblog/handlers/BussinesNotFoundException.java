package com.personalblog.handlers;

public class BussinesNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public BussinesNotFoundException(String message) {
		super(message);
	}

}
