package com.webapp.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webapp.hotel.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

	@Query ("select p from Payment p where p.booking.id = :id")
	public List<Payment> findByBookingid(@Param("id") Long id);	

}
