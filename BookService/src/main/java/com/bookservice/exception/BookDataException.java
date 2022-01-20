package com.bookservice.exception;

@SuppressWarnings("serial")
public class BookDataException extends RuntimeException {
	
	public BookDataException(String message) {
		super(message);
	}
}
