package com.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderservice.dto.OrderAddressDto;
import com.orderservice.entity.OrderAddress;
import com.orderservice.entity.UserData;
import com.orderservice.exception.OrderException;
import com.orderservice.repository.OrderAddressRepository;

@Service
public class OrderAddressService implements IOrderAddressService {


	@Autowired
	private OrderAddressRepository orderAddressRepo;
	
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
	public List<OrderAddress> getAddress(String token) {
		UserData userData = isUserPresent(token);
		return orderAddressRepo.findAll();
	}

	@Override
	public String addAddress(String token, OrderAddressDto orderAddressDto) {
		UserData userData = isUserPresent(token);
		OrderAddress orderAddress = new OrderAddress(orderAddressDto, userData.getUserId());
		orderAddressRepo.save(orderAddress);
		return "Address Added Sucessfully";
	}

}
