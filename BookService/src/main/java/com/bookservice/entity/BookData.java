package com.bookservice.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import com.bookservice.dto.BookDataDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	@Type(type = "uuid-char")
	private UUID bookId;

	@Column(name = "book_name")
	private String bookName;

	@Column(name = "book_author")
	private String bookAuthor;

	private Double rating;

	@Column(name = "book_price")
	private Double bookPrice;
	
	private Double bookOldPrice;

	@Column(name = "book_quantity")
	private Long bookQuantity;

	@Column(name = "book_desciption")
	private String bookDescription;

	@Column(name = "book_image")
	private String bookImage;
	
	public LocalDateTime createdAt = LocalDateTime.now();
	
	public BookData(UUID bookId, BookDataDTO bookDataDto) {
		this.bookId = bookId;
		this.bookName = bookDataDto.getBookName();
		this.bookAuthor = bookDataDto.getBookAuthor();
		this.rating = bookDataDto.getRating();
		this.bookPrice = bookDataDto.getBookPrice();
		this.bookOldPrice=bookDataDto.getBookOldPrice();
		this.bookQuantity = bookDataDto.getBookQuantity();
		this.bookDescription = bookDataDto.getBookDescription();
		this.bookImage = bookDataDto.getBookImage();
	}

	public BookData(BookDataDTO bookDataDto) {
		this.bookName = bookDataDto.getBookName();
		this.bookAuthor = bookDataDto.getBookAuthor();
		this.rating = bookDataDto.getRating();
		this.bookPrice = bookDataDto.getBookPrice();
		this.bookOldPrice=bookDataDto.getBookOldPrice();
		this.bookQuantity = bookDataDto.getBookQuantity();
		this.bookDescription = bookDataDto.getBookDescription();
		this.bookImage = bookDataDto.getBookImage();
	}
}
