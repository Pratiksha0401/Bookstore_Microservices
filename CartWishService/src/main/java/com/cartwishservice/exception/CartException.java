package com.cartwishservice.exception;

@SuppressWarnings("serial")
public class CartException extends RuntimeException {

	public CartException(String message) {
		super(message);
	}
}
