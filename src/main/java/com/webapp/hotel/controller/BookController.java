package com.webapp.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.webapp.hotel.entity.Booking;
import com.webapp.hotel.entity.User;
import com.webapp.hotel.service.BookService;

@Controller
public class BookController {

	@Autowired 
	private BookService bookService;
	/*
	@GetMapping("/booking")
	public String createBooking(Model model) {
		model.addAttribute("Booking", new Booking());
		return "booking-form";
		}
	*/
	
}
