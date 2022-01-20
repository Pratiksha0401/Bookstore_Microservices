package com.userservice.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import com.userservice.dto.UserDataDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class UserData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type="uuid-char")
	private UUID userId;
	
	private String fullName;
	private String phoneNumber;
	private String emailID;
	private String password;
	public boolean isVerified;
    public LocalDateTime createdAt = LocalDateTime.now();
    
    public UserData() { }
    
	public UserData(UserDataDTO userdto) {
		this.fullName = userdto.getFullName();
		this.phoneNumber = userdto.getPhoneNumber();
		this.emailID = userdto.getEmailId();
		this.password = userdto.getPassword();
	}

	public UserData(UUID userId, UserDataDTO userdto) {
		this.userId = userId;
		this.fullName = userdto.getFullName();
		this.phoneNumber = userdto.getPhoneNumber();
		this.emailID = userdto.getEmailId();
		this.password = userdto.getPassword();
	}
	
    public UserData(String fullName, String phoneNumber, String emailID, String password) {
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.emailID = emailID;
		this.password = password;
	}   

}
