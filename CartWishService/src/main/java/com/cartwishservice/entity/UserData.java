package com.cartwishservice.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class UserData {
	
	@Type(type="uuid-char")
	private UUID userId;
	
	private String fullName;
	private String phoneNumber;
	private String emailID;
	private String password;
	public boolean isVerified;
    public LocalDateTime createdAt;
   
}
