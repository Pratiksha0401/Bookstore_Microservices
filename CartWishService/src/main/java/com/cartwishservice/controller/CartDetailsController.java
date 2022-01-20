package com.cartwishservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/updateCart/{cartId}/{quantity}")
	public ResponseEntity<ResponseDTO> updateCart(@RequestHeader(value = "token") String token,
			@PathVariable UUID cartId, @PathVariable Long quantity) {

		String cartData = cartDetailsService.updateCart(token, cartId, quantity);

		ResponseDTO responseDTO = new ResponseDTO("Response Successful", cartData);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
	
	@PutMapping("/updateStatus/{cartId}/{status}")
	public ResponseEntity<ResponseDTO> updateStatus(@RequestHeader(value = "tokenId") String tokenId,
			@PathVariable UUID cartId, @PathVariable String status) {
		String cartData = cartDetailsService.updateStatus(tokenId, cartId, status);
		ResponseDTO responseDTO = new ResponseDTO("Response Successful", cartData);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCart/{cartId}")
	public ResponseEntity<ResponseDTO> deleteCart(@RequestHeader(value = "token") String token,
			@PathVariable UUID cartId) {

		String cartData = cartDetailsService.deleteCart(token, cartId);

		ResponseDTO responseDTO = new ResponseDTO("Response Successful", cartData);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
	
	//@GetMapping("/getcart/{cartId}")
	@GetMapping("/getcart/{cartId}")
	//public CartDetails getCart(@RequestHeader(value = "token") String token, @PathVariable UUID cartId)
	public CartDetails getCart(@PathVariable UUID cartId){
		CartDetails cartDetails = cartDetailsService.getCart(cartId);
		return cartDetails;
	}
	
	@DeleteMapping("/deleteCartForOrder/{cartId}")
	public String deleteCartForOrder(@PathVariable UUID cartId) {
		String cartData = cartDetailsService.deleteCart(cartId);
		return cartData;
	}
	
	@GetMapping("/getcartbyuserIdandcartId/{cartId}")
	public ResponseEntity<ResponseDTO> getcartbyuseridandcartid(@RequestHeader(value = "token") String token,
																@PathVariable UUID cartId) {
		CartDetails cartDetailsList = cartDetailsService.getCartByUserIdandCartId(token,cartId);
		ResponseDTO responseDTO = new ResponseDTO("Response Successful", cartDetailsList);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

}
