package com.xchange.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xchange.models.Company;
import com.xchange.models.DTO;
import com.xchange.models.User;
import com.xchange.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService service;

	// [DEV] - Method tested using Postman by WS on 28DEC2017 00:10
	@RequestMapping(value="/AddNewUser", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public User addUser(@RequestBody User newUser) {
		System.out.println("[LOG] - In /AddNewUser");
		return service.addUser(newUser);
	}
	
	// [DEV] - Method tested using Postman by WS on 28DEC2017 00:15
	@RequestMapping(value="/UpdateUser", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public User updateUser(@RequestBody User updatedUser) {
		System.out.println("[LOG] - In /UpdateUser");
		return service.updateUserById(updatedUser.getUserId(), updatedUser);
	}
	
	// [DEV] - Method tested using Postman by WS on 27DEC2017 16:30
	@RequestMapping(value="/GetAllUsers", method=RequestMethod.GET)
	public List<User> findAllUsers() {
		System.out.println("[LOG] - In /GetAllUsers");
		System.out.println(service.findAllUsers());
		return service.findAllUsers();
	}
	
	// [DEV] - Method tested using Postman by WS on 28DEC2017 00:20
	@RequestMapping(value="/GetUserById", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public User findUserById(@RequestBody User user) {
		System.out.println("[LOG] - In /GetUserById");
		System.out.println(service.findUserById(user.getUserId()));
		return service.findUserById(user.getUserId());
	}
	
	// [DEV] - Method tested using Postman by WS on 28DEC2017 00:30
	@RequestMapping(value="/GetUserByUsername", method=RequestMethod.POST)
	public User findUserByUsername(@RequestBody User user) {
		System.out.println("[LOG] - In /GetUserByUsername");
		return service.findUserByUsername(user.getUsername());
	}
	
	// [DEV] - Method tested using Postman by WS on 28DEC2017 00:33
	@RequestMapping(value="/GetUserByEmail", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public User findUserByEmail(@RequestBody User user) {
		System.out.println("[LOG] - In /GetUserByEmail");
		return service.findUserByEmail(user.getEmail());
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
    public User loginUser(@RequestBody User user) {
		return service.loginUser(user);
    }
	
	// [DEV] - Method tested using Postman by WS on 29DEC2017 20:56
	@RequestMapping(value="/AddUserSubscription", method=RequestMethod.POST)
	public Set<User> addUserSubscription(@RequestBody User[] users) {
		System.out.println("[LOG] - In /AddUserSubscription");
		return service.addUserSubscription(users[0].getUserId(), users[1].getUserId());
	}
	
	// [DEV] - Method tested using Postman by WS on 31DEC2017 15:50
	@RequestMapping(value="/AddUserFavorite", method=RequestMethod.POST)
	public Set<Company> addUserFavorite(@RequestBody DTO dto) {
		System.out.println("[LOG] - In /AddUserFavorite");
		return service.addUserFavorite(dto.getUserId(), dto.getCompanyId());
	}
	
	// [DEV] - Method tested using Postman by WS on 29DEC2017 21:05
	@RequestMapping(value="/GetAllUserSubscriptions", method=RequestMethod.POST)
	public Set<User> getAllUserSubscriptions(@RequestBody User user) {
		System.out.println("[LOG] - In /GetAllUserSubscription");
		return service.findAllUserSubscriptions(user.getUserId());
	}
	
	// [DEV] - Method tested using Postman by WS on 31DEC2017 15:55
	@RequestMapping(value="/GetAllUserFavorites", method=RequestMethod.POST)
	public Set<Company> getAllUserFavorites(@RequestBody User user) {
		System.out.println("[LOG] - In /GetAllUserFavorites");
		return service.findAllUserFavorites(user.getUserId());
	}
	

	// [DEV] - Method tested using Postman by WS on 29DEC2017 21:10
	@RequestMapping(value="/RemoveUserSubscription", method=RequestMethod.POST)
	public void removeUserSubscription(@RequestBody User[] users) {
		System.out.println("[LOG] - In /RemoveUserSubscription");
		service.removeUserSubscription(users[0].getUserId(), users[1].getUserId());
	}
	
	// [DEV] - Method tested using Postman by WS on 31DEC2017 16:01
	@RequestMapping(value="/RemoveUserFavorite", method=RequestMethod.POST)
	public void removeUserFavorite(@RequestBody DTO dto) {
		System.out.println("[LOG] - In /RemoveUserFavorite");
		service.removeUserFavorite(dto.getUserId(), dto.getCompanyId());
	}
	
	// [DEV] - Method tested using Postman by WS on 02JAN2018 20:15
	@RequestMapping(value="/GetUserSubscribers", method=RequestMethod.POST)
	public Set<User> getUserSubscribers(@RequestBody User user) {
		Set<User> userSubscribers = new HashSet<>();
		for(User u : service.findAllUsers()) {
			for(User _user : u.getUserSubscriptions()) {
				if(_user.getUserId() == user.getUserId()) {
					userSubscribers.add(u);
				}
			}
		}
		return userSubscribers;
	}
		
}
