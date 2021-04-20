package com.webapp.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webapp.hotel.entity.Booking;

public interface BookRepository extends JpaRepository<Booking, Long>{

	@Query ("select b from Booking b where b.guest.id = :id")
	public List<Booking> findAllbyUserid(@Param("id") Long id);	

}
