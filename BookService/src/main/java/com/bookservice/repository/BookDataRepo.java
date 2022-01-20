package com.bookservice.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookservice.entity.BookData;

public interface BookDataRepo extends JpaRepository<BookData, UUID>  {

	Optional<BookData> findByBookName(String bookName);
	
	List<BookData>findByBookNameContaining(String name);
	
	BookData findByBookId(UUID bookId);
	
	
}