package com.orderservice.service;

import java.util.UUID;

public interface IOrdredService {

	String createOrder(String token, UUID cartId);

	Long getOrderByToken(String token);

}