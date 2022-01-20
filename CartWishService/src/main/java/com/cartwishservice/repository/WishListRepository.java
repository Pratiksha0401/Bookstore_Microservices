package com.cartwishservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cartwishservice.entity.WishList;

public interface WishListRepository extends JpaRepository<WishList, UUID> {
	
	List<WishList> findByUserId(UUID userId);
}