package com.cognizant.menuitem.exception;

@SuppressWarnings("serial")
public class CartEmptyException extends Exception {
	
	String message;

	public CartEmptyException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
