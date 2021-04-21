package com.webapp.hotel.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.webapp.hotel.entity.Booking;
import com.webapp.hotel.entity.User;
import com.webapp.hotel.repository.BookRepository;
import com.webapp.hotel.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired 
	private UserServiceImp userServiceImp;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;

	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}
	
	public void addUser(User user) {
		userServiceImp.create(user);
	    userRepository.save(user);
	}
	
	public User getUser(Long id) {
	    return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}
	
	public User replaceUser(User user, Long id) {
	    return userRepository.findById(id)
	      .map(u -> {
	        u.setEmail(user.getEmail());
	        u.setPassword(user.getPassword());
	        u.setFirstName(user.getFirstName());
	        u.setLastName(user.getLastName());
	        return userRepository.save(u);
	      })
	      .orElseGet(() -> {
	        return userRepository.save(user);
	      });
	}

	public void deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
	
	public User findUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}
	
	public Long findUserIDByUsername(String username) {
		return userRepository.findUserIDByUsername(username);
	}
	
	public List<Booking> retrieveUserBookingsbyId(Long id){
		return bookRepository.findAllbyUserid(id);
	}
	
}
