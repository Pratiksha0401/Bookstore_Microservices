package com.bookservice.service;

import java.util.List;
import java.util.UUID;

import com.bookservice.dto.BookDataDTO;
import com.bookservice.entity.BookData;

public interface IBookService {
	BookData addNewBook(BookDataDTO dto);

	List<BookData> getAllBooks(Integer pageNo, Integer pageSize);

	List<BookData> getAllBookByPriceHighToLow(Integer pageNo, Integer pageSize);

	List<BookData> getAllBookByPriceLowToHigh(Integer pageNo, Integer pageSize);

	List<BookData> getAllBookByNewArrival(Integer pageNo, Integer pageSize);

	List<BookData> searchBookByName(String name);

	Long getBooksCount();

	BookData getBookById(UUID bookId);

	String updateQuantity(String token, UUID bookId, Long quantity);
}
