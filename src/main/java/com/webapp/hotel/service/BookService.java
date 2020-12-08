package com.webapp.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.webapp.hotel.entity.Booking;
import com.webapp.hotel.entity.User;
import com.webapp.hotel.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired 
	private BookRepository bookRepository;
	@Autowired
	private UserService userService;
	
	
	public void addBook(Booking book) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
		  book.setGuest(userService.findUserByUsername(username));
		} else {
		 String username = principal.toString();
		 book.setGuest(userService.findUserByUsername(username));
		}
		bookRepository.save(book);
	}
	
	public List<Booking> allBooksbyUserid(User user){
		return bookRepository.findAllbyUserid(user.getId());
	}

		
}
