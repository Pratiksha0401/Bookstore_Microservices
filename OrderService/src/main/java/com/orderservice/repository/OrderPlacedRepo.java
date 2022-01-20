package com.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderservice.entity.OrderPlaced;

public interface OrderPlacedRepo extends JpaRepository<OrderPlaced, Long>{

}