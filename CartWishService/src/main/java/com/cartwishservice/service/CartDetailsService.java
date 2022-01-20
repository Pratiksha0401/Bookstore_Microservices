package com.cartwishservice.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cartwishservice.CartProxy;
import com.cartwishservice.dto.CartDetailsDto;
import com.cartwishservice.dto.ResponseDTO;
import com.cartwishservice.entity.BookData;
import com.cartwishservice.entity.CartDetails;
import com.cartwishservice.entity.UserData;
import com.cartwishservice.exception.CartException;
import com.cartwishservice.repository.CartDetailsRepository;

import antlr.Token;

@Service
public class CartDetailsService implements ICartDetails {

	@Autowired
	CartDetailsRepository cartDetailsRepo;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CartProxy cartProxy;

	public UserData isUserPresent(String token) {
		UserData userDetailsById = restTemplate
				.getForObject("http://localhost:8100/user/getuser?userEmailToken= " + token, UserData.class);
		// System.out.println("user data: "+userDetailsById.getUserId());
		if (userDetailsById.getUserId() == null) {
			throw new CartException("User Not Found");
		}
		return userDetailsById;
	}

	@Override
	public List<CartDetails> getAllCarts(String token) {
		UserData userData = isUserPresent(token);
		UUID userId = userData.getUserId();
		return cartDetailsRepo.findByUserId(userId);
	}

	@Override
	public String addBookToCart(String token, CartDetailsDto cartDto, UUID bookId) {
		UserData userData = this.isUserPresent(token);
		BookData bookData = restTemplate.getForObject("http://localhost:8200/bookdata/" + bookId, BookData.class);
		CartDetails cartDetails = cartDetailsRepo.findByBookId(bookId);
		System.out.println("cart :"+cartDetails);
		if (cartDetails!=null) {
			throw new CartException("Book Already Present");
		}
		cartDetails = new CartDetails(cartDto, bookData, userData.getUserId());
		cartDetailsRepo.save(cartDetails);
		return "Book added to cart sucessfully";
	}
}