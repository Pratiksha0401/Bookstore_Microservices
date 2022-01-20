package com.orderservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.dto.ResponseDTO;
import com.orderservice.service.IOrdredService;

@RestController
@CrossOrigin
@RequestMapping("/orderPlaced")
public class OrderPlacedController {

	@Autowired
	private IOrdredService orderService;

	@PostMapping("/order/{cartId}")
	ResponseEntity<ResponseDTO> createOrderId(@RequestHeader(value = "tokenId") String tokenId,
												@PathVariable UUID cartId,
												@RequestParam Double totalprice) {
		String placedOrder = orderService.createOrder(tokenId, cartId);
		ResponseDTO responseDTO = new ResponseDTO("OrderAdded SuccessFully", placedOrder);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/getOrderId")
	ResponseEntity<ResponseDTO> getOrderId(@RequestHeader(value = "tokenId") String tokenId) {
		Long uuidPlaceOrder = orderService.getOrderByToken(tokenId);
		ResponseDTO responseDTO = new ResponseDTO("Order Id Get successfully", uuidPlaceOrder);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

}
