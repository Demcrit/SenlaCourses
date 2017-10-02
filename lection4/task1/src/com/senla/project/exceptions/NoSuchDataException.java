package com.senla.project.exceptions;

@SuppressWarnings("serial")
public class NoSuchDataException extends Exception {
	
	private static final String MESSAGE = "No such data,try again";
	
	public String getMessage(){
		return MESSAGE;
	}
}
