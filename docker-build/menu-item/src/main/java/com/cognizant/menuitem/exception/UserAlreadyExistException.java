package com.cognizant.menuitem.exception;

@SuppressWarnings("serial")
public class UserAlreadyExistException extends Exception{
	
	String message;

	public UserAlreadyExistException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
