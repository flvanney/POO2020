package com.webapp.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.webapp.hotel.entity.Booking;
import com.webapp.hotel.entity.Cancelacion;
import com.webapp.hotel.entity.Payment;
import com.webapp.hotel.service.BookService;
import com.webapp.hotel.service.PaymentService;

@Controller
public class BookController {

	@Autowired 
	private BookService bookService;
	
	@Autowired
	private PaymentService paymentService;
	
	
	@GetMapping("/booking/{id}")
	public String getPaymentForm(@PathVariable Long id, Model model) {
		model.addAttribute("Payment", new Payment());
		model.addAttribute("reserva", bookService.getBook(id));
		return "booking-payment";
	}
	
	@PostMapping("/booking/{id}")
	public String addPayment(@ModelAttribute Payment payment, Booking book, Model model) {
		model.addAttribute("Payment", payment);
		paymentService.addPayment(payment, book);
		return "redirect:/home";
	}
	
	@GetMapping("/booking/{id}/cancelation")
	public String getCancelationForm(@PathVariable Long id, Model model) {
		model.addAttribute("reserva", bookService.getBook(id));
		return "cancelation-form";
	}
	
	@PostMapping("/booking/{id}/cancelation")
	public String addCancelation(Booking book, Model model) {
		bookService.addCancelation(book);
		return "cancelation-success";
	}
}
