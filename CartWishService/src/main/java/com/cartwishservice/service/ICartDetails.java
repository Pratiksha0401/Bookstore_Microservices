package com.cartwishservice.service;

import java.util.List;
import java.util.UUID;

import com.cartwishservice.dto.CartDetailsDto;
import com.cartwishservice.entity.CartDetails;

public interface ICartDetails {

	List<CartDetails> getAllCarts(String Token);

	String addBookToCart(String Token, CartDetailsDto cartDto, UUID bookId);

}
