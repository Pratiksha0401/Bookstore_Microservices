package com.orderservice.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderservice.entity.BookData;
import com.orderservice.entity.CartDetails;
import com.orderservice.entity.OrderPlaced;
import com.orderservice.entity.UserData;
import com.orderservice.exception.OrderException;
import com.orderservice.repository.OrderPlacedRepo;

@Service
public class OrderPlacedService implements IOrdredService {

	@Autowired
	OrderPlacedRepo orderRepo;

	@Autowired
	RestTemplate restTemplate;

	public UserData isUserPresent(String token) {
		UserData userDetailsById = restTemplate
				.getForObject("http://user-service/user/getuser?userEmailToken= " + token, UserData.class);
		// System.out.println("user data: "+userDetailsById.getUserId());
		if (userDetailsById.getUserId() == null) {
			throw new OrderException("User Not Found");
		}
		return userDetailsById;
	}

	@Override
	public String createOrder(String token, UUID cartId) {
		UserData userData = isUserPresent(token);
		CartDetails cartDetails = restTemplate.
				getForObject("http://cart-wish-service/cart/getcart/"+cartId, 
				CartDetails.class);
		BookData bookData = restTemplate.
				getForObject("http://book-service/bookdata/" + cartDetails.getBookId(), 
				BookData.class);
		restTemplate.delete("http://cart-wish-service/cart/deleteCartForOrder/"+ cartId);
		OrderPlaced placedOrder = new OrderPlaced(userData.getUserId(), bookData.getBookId());
		orderRepo.save(placedOrder);
		return "Order Added Successfully.";
	}

	@Override
	public Long getOrderByToken(String token) {
		UserData userData = isUserPresent(token);
		OrderPlaced placedOrder = new OrderPlaced(LocalDateTime.now());
		orderRepo.save(placedOrder);
		return orderRepo.count() + 10000;
	}
}
