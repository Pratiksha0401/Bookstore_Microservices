package com.cartwishservice.service;

import java.util.List;
import java.util.UUID;

import com.cartwishservice.dto.CartDetailsDto;
import com.cartwishservice.entity.CartDetails;

public interface ICartDetails {

	List<CartDetails> getAllCarts(String Token);

	String addBookToCart(String Token, CartDetailsDto cartDto, UUID bookId);

	String updateCart(String token, UUID cartId, Long quantity);

	String deleteCart(UUID cartId);

	String updateStatus(String token, UUID cartId, String status);

	CartDetails getCart(UUID cartId);

	String deleteCart(String token, UUID cartId);
	
	CartDetails getCartByUserIdandCartId(UUID userId,UUID cartId);

	CartDetails getCartByUserIdandCartId(String token, UUID cartId);

}
