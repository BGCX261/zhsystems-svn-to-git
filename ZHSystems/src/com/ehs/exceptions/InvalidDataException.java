package com.ehs.exceptions;

public class InvalidDataException extends RuntimeException {
	

	private static final long serialVersionUID = 4725307345778296107L;

	public InvalidDataException(String msg) {
		super(msg);
	}
}
