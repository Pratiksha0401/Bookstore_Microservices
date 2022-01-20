package com.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.dto.OrderAddressDto;
import com.orderservice.dto.ResponseDTO;
import com.orderservice.entity.OrderAddress;
import com.orderservice.service.IOrderAddressService;

@RestController
@CrossOrigin
public class OrderAddressController {
	
	@Autowired
	private IOrderAddressService orderAddressService;

	@GetMapping("/getaddress")
	public ResponseEntity<ResponseDTO> getAddress(@RequestHeader(value = "token") String token)
	{
		List<OrderAddress> userAddress = orderAddressService.getAddress(token);
		ResponseDTO responseDTO = new ResponseDTO("Response Successful", userAddress);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
	
	@PostMapping("/address")
	public ResponseEntity<ResponseDTO> setAddress(@RequestHeader(value = "token") String token,
													@RequestBody OrderAddressDto orderAddressDto ) {

		String cartData = orderAddressService.addAddress(token, orderAddressDto);

		ResponseDTO responseDTO = new ResponseDTO("Response Successful", cartData);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
	
}
