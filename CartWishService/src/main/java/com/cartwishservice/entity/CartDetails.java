package com.cartwishservice.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.cartwishservice.dto.CartDetailsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
	private UUID cartId;
	
	private Long quantity;
	
	private String status;
	
	@Type(type = "uuid-char")
	private UUID bookId;
	
	@Type(type = "uuid-char")
	private UUID userId;
	
	public CartDetails( CartDetailsDto cartDetailsdto, BookData bookData, UUID userId) {
		this.quantity=cartDetailsdto.getQuantity();
		this.status=cartDetailsdto.getStatus();
		this.bookId=bookData.getBookId();
		this.userId=userId;
	}
	

	public CartDetails(CartDetailsDto cartDetailsdto) {
		this.quantity=cartDetailsdto.getQuantity();
		this.status=cartDetailsdto.getStatus();
	}}
