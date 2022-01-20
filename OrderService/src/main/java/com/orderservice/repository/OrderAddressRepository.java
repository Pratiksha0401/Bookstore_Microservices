package com.orderservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderservice.entity.OrderAddress;

public interface OrderAddressRepository extends JpaRepository<OrderAddress, UUID> {

}
