package com.cartwishservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cartwishservice.entity.CartDetails;

public interface CartDetailsRepository extends JpaRepository<CartDetails, UUID>{
	CartDetails findByCartId(UUID cartId);
	//Optional<UserData> findByUserData(UserData userData);
	
//	@Query(value="select * from user_data where user_id:userId", nativeQuery = true)
	List<CartDetails> findByUserId(UUID userId );
	
	//@Query(value=" select * from cart_details where book_id:bookId" , nativeQuery = true)
	public CartDetails findByBookId(UUID bookId);
	
	@Query(value=" delete from cart_details where cart_id:cartId" , nativeQuery = true)
	void deleteCart(UUID cartId);
	
	@Query(value=" select * from cart_details where user_id:userId and cart_id:cartId" , nativeQuery = true)
	CartDetails findUserIdAndCartId(UUID userId, UUID cartId);
	
}
