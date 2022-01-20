package com.orderservice.entity;

import java.util.UUID;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetails {

	@Type(type = "uuid-char")
	private UUID cartId;

	private Long quantity;

	private String status;

	@Type(type = "uuid-char")
	private UUID bookId;

	@Type(type = "uuid-char")
	private UUID userId;
}
