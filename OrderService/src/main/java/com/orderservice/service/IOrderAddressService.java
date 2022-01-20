package com.orderservice.service;

import java.util.List;

import com.orderservice.dto.OrderAddressDto;
import com.orderservice.entity.OrderAddress;

public interface IOrderAddressService {

	List<OrderAddress> getAddress(String token);

	String addAddress(String token, OrderAddressDto orderAddressDto);
}
