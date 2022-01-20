package com.userservice.exception;

@SuppressWarnings("serial")
public class UserDataException extends RuntimeException {

	public UserDataException(String message) {
		super(message);
	}
}