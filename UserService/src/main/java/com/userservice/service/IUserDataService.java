package com.userservice.service;

import javax.mail.MessagingException;

import com.userservice.dto.ResetPasswordDto;
import com.userservice.dto.UpdateUserDTO;
import com.userservice.dto.UserDataDTO;
import com.userservice.dto.UserLoginDTO;
import com.userservice.entity.UserData;

public interface IUserDataService {
	public UserData createNewUser(UserDataDTO userdto);

	public void verifyEmail(String tokenId);

	public String userLogin(UserLoginDTO userLoginDto);

	public String sendPasswordResetLink(String emailId) throws MessagingException;

	public String resetPassword(ResetPasswordDto resetPasswordDto, String token);

	public UserData getUserById(String tokenId);

	public UserData updateUserData(String token, UpdateUserDTO userDataDto);

	public UserData getUser(String token);

	//UserData updateUserData(String token, UpdateUserDTO userData);
}
