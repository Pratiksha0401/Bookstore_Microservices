package com.userservice.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.entity.UserData;

public interface UserDataRepository extends JpaRepository<UserData, UUID> {

	Optional<UserData> findByEmailID(String emailId);

}
