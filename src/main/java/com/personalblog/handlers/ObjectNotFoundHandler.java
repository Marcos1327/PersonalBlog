package com.personalblog.handlers;

public class ObjectNotFoundHandler extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundHandler(String message) {
		super(message);
	}

}
