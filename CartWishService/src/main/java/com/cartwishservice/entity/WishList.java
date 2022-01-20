package com.cartwishservice.entity;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
	private UUID wishListId;

	@Type(type = "uuid-char")
	private UUID bookId;
	
	@Type(type = "uuid-char")
	private UUID userId;

	public WishList(UUID userId, UUID bookId) {
		this.userId = userId;
		this.bookId = bookId;

	}
}
