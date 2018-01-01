package com.xchange.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xchange.models.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
	
	User findUserByUsername(String username);
	User findUserByEmail(String email);
	public User findUserByUsernameAndPassword(String username, String password);
	
	@Modifying
	@Query("UPDATE User u SET u = :updated WHERE u.userId = :userId")
	User updateUserById(@Param("userId") Long userId, @Param("updated") User updatedUser);
	
}
