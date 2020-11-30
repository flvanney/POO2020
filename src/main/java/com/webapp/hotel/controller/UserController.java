package com.webapp.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.hotel.service.UserService;
import com.webapp.hotel.entity.User;



@Controller
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
	
	
	@GetMapping("/users/new")
	public String crearUsuario(Model model){
		model.addAttribute("User", new User());
		return "form";
	}
	
	@PostMapping("/users/new")
	public String addUser(@ModelAttribute User user, Model model) {
		model.addAttribute("User", user);
		user.setRole("USER");
		userservice.addUser(user);
		return "redirect:/login";
	}
	
	@GetMapping("/")
	public String saludo() {
		return "index";
	}
}
