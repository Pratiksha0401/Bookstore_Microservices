package com.cartwishservice;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cartwishservice.entity.BookData;

@FeignClient(name="bookdata", url="localhost:8200")
public interface CartProxy {

	@GetMapping("/bookdata/{bookId}")
	BookData retrieveBook(@PathVariable UUID bookId) ;

}
