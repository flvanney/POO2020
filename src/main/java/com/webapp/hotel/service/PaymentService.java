package com.webapp.hotel.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webapp.hotel.entity.Payment;
import com.webapp.hotel.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public void addPayment(Payment payment) {
		LocalDate lt = LocalDate.now();
		payment.setCreatedAt(lt);
		paymentRepository.save(payment);
	}
}
	//public void addPayment(Payment payment, Long bookingid)