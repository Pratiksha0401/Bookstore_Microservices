package com.orderservice.exception;

@SuppressWarnings("serial")
public class OrderException extends RuntimeException {

	public OrderException(String message) {
			super(message);
		}
}
