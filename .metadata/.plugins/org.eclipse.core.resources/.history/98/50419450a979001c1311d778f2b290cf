package com.cartwishservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cartwishservice.dto.CartDetailsDto;
import com.cartwishservice.dto.ResponseDTO;
import com.cartwishservice.entity.CartDetails;
import com.cartwishservice.service.ICartDetails;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartDetailsController {

	@Autowired
	ICartDetails cartDetailsService;

	@GetMapping("/getcartdeatails")
	public ResponseEntity<ResponseDTO> getBooks(@RequestHeader(value = "token") String token) {
		List<CartDetails> cartDetailsList = cartDetailsService.getAllCarts(token);
		ResponseDTO responseDTO = new ResponseDTO("Response Successful", cartDetailsList);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/addBookToCart/{bookId}")
	public ResponseEntity<ResponseDTO> addBookToCart(@RequestHeader(value = "token") String token,
			@RequestBody CartDetailsDto cartDto, @PathVariable UUID bookId) {

		String cartData = cartDetailsService.addBookToCart(token, cartDto, bookId);

		ResponseDTO responseDTO = new ResponseDTO("Response Successful", cartData);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

}
