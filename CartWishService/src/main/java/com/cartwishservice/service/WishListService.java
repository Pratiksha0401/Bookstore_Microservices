package com.cartwishservice.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cartwishservice.entity.BookData;
import com.cartwishservice.entity.UserData;
import com.cartwishservice.entity.WishList;
import com.cartwishservice.exception.CartException;
import com.cartwishservice.repository.WishListRepository;

@Service
public class WishListService implements IWishListService {

	@Autowired
	private WishListRepository wishListRepository;

	@Autowired
	RestTemplate restTemplate;

	public UserData isUserPresent(String token) {
		UserData userDetailsById = restTemplate
				.getForObject("http://user-service/user/getuser?userEmailToken= " + token, UserData.class);
		// System.out.println("user data: "+userDetailsById.getUserId());
		if (userDetailsById.getUserId() == null) {
			throw new CartException("User Not Found");
		}
		return userDetailsById;
	}

	@Override
	public List<WishList> getBooks(String token) {
		UserData userData = isUserPresent(token);
		return wishListRepository.findByUserId(userData.getUserId());
	}

	@Override
	public String addBookToWishList(String token, UUID bookId) {
		UserData userData = this.isUserPresent(token);
		BookData bookData = restTemplate.getForObject("http://book-service/bookdata/" + bookId, 
				BookData.class);
	
		WishList wishList = new WishList(userData.getUserId(), bookData.getBookId());
		wishListRepository.save(wishList);
		return "Book added to WishList sucessfully";

	}

	@Override
	public String deleteBookFromWishList(String token, UUID wishListId) {
		UserData userData = this.isUserPresent(token);
		WishList wishList = wishListRepository.findById(wishListId).
					orElseThrow(() -> new CartException("WishList is not found"));
		wishListRepository.delete(wishList);
		return "WishList Deleted successfully";
	}
}