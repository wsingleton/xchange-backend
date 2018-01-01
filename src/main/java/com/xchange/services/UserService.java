package com.xchange.services;

import java.util.List;
import java.util.Set;

import com.xchange.models.Company;
import com.xchange.models.User;

public interface UserService {
	
	User addUser(User newUser);
	List<User> findAllUsers();
	User findUserById(Long id);
	User findUserByUsername(String username);
	User findUserByEmail(String email);
	User updateUserById(Long userId, User u);
	User loginUser(User u);
	Set<User> addUserSubscription(Long user1_id, Long user2_id);
	Set<Company> addUserFavorite(Long user_id, Long company_id);
	Set<User> findAllUserSubscriptions(Long user_id);
	Set<Company> findAllUserFavorites(Long user_id);
	void removeUserSubscription(Long user1_id, Long user2_id);
	void removeUserFavorite(Long user1_id, Long user2_id);

}
