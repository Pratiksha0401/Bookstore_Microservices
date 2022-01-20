package com.orderservice.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderPlaced {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	private Double totalprice;

	public LocalDateTime createdAt = LocalDateTime.now();
	
	@Type(type = "uuid-char")
	private UUID bookId;
	
	@Type(type = "uuid-char")
	private UUID userId;

	public OrderPlaced( UUID userId , UUID bookId) {
		this.userId =userId;
		this.bookId = bookId;
	}

	public OrderPlaced(LocalDateTime now) {
		this.createdAt = now;
	}
}