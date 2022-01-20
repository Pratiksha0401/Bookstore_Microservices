package com.orderservice.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BookData {
	
	@Type(type = "uuid-char")
	private UUID bookId;

	private String bookName;

	private String bookAuthor;

	private Double rating;

	private Double bookPrice;

	private Double bookOldPrice;

	private Long bookQuantity;

	private String bookDescription;

	private String bookImage;

	public LocalDateTime createdAt;

}
