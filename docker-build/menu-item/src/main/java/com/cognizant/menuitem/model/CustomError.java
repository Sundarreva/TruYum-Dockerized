package com.cognizant.menuitem.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class CustomError {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomError.class);
	
	String errorMessage;
	String errorCode;
	Date date;
	
	public CustomError(String errorMessage, String errorCode, Date date) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.date = date;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CustomError [errorMessage=" + errorMessage + ", errorCode=" + errorCode + ", date=" + date + "]";
	}
	
}
