package com.webapp.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.hotel.service.UserService;
import com.webapp.hotel.entity.User;



@RestController
public class UserController {

	@Autowired
	private UserService userservice;
	
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return userservice.retrieveAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
	    return userservice.getUser(id);
	}
	
	@PostMapping("/users/new")
	public void addUser(@RequestBody User user) {
		userservice.addUser(user);
	}
	
	@GetMapping("/users/new")
	public String getmensaje() {
		return "newuser";
	}
	
	
}
