package com.cartwishservice.service;

import java.util.List;
import java.util.UUID;

import com.cartwishservice.entity.WishList;

public interface IWishListService {
	List<WishList> getBooks(String token);

	String addBookToWishList(String token, UUID bookId);

	String deleteBookFromWishList(String token, UUID wishListId);
}
