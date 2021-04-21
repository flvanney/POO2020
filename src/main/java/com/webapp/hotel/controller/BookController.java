package com.webapp.hotel.controller;


import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.webapp.hotel.entity.Booking;
import com.webapp.hotel.entity.Payment;
import com.webapp.hotel.entity.Room;
import com.webapp.hotel.entity.User;
import com.webapp.hotel.service.BookService;
import com.webapp.hotel.service.PaymentService;

@Controller
public class BookController {

	@Autowired 
	private BookService bookService;
	
	@Autowired
	private PaymentService paymentService;
	
	/*
	@GetMapping("/booking")
	public String createBooking(Model model) {
		model.addAttribute("Booking", new Booking());
		return "booking-form";
		}
	*/
	
	@GetMapping("/booking/{id}")
	public String getPaymentForm(@PathVariable Long id, Model model) {
		model.addAttribute("Payment", new Payment());
		model.addAttribute("reserva", bookService.getBook(id));
		return "booking-payment";
		
	}
	
	@PostMapping("/booking/{id}")
	public String addPayment(@ModelAttribute Payment payment, Booking book, Model model) {
		model.addAttribute("Payment", payment);
		payment.setBooking(book);
		paymentService.addPayment(payment);
		return "redirect:/home";
	}
	/*
	 * @PostMapping("/rooms/{id}") 
	 * public String addBook(@ModelAttribute Booking booking, Room room, Model model) { 
	 * model.addAttribute("Booking", booking);
	 * //model.addAttribute("Room", room); booking.setRoom(room);
	 * booking.setCreatedAt(new Date());
	 * //booking.setCost(roomService.getPricebyid(room.getId()));
	 * booking.setCost(bookService.calcularPrecio(roomService.getPricebyid(room.getId()), booking.isBreakfastIncluded(), booking.isParking(),booking.isFreeCancelation(), ChronoUnit.DAYS.between(booking.getCheckIn(),booking.getCheckOut()))); bookService.addBook(booking); 
	 * return "booking-success"; }
	 */
	
	
}
