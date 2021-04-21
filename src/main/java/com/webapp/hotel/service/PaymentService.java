package com.webapp.hotel.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.hotel.entity.Booking;
import com.webapp.hotel.entity.Payment;
import com.webapp.hotel.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private BookService bookService;
	
	public void addPayment(Payment payment, Booking book) {
		LocalDate lt = LocalDate.now();
		payment.setCreatedAt(lt);
		payment.setBooking(book);
		paymentRepository.save(payment);
		bookService.payBook(book);
	}
}