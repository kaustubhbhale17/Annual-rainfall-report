package com.exception;

public class InvalidPinCodeException extends Exception{
	
	
	private static final long serialVersionUID = 1L;

	public InvalidPinCodeException(String msg) {
		super(msg);
	}
}
