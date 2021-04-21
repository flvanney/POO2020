package com.webapp.hotel.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webapp.hotel.entity.Booking;

public interface BookRepository extends JpaRepository<Booking, Long>{

	@Query ("select b from Booking b where b.guest.id = :id")
	public List<Booking> findAllbyUserid(@Param("id") Long id);	

	@Modifying
	@Transactional
	@Query ("update Booking b set b.isPaid='true' where b.id = :id")
	public void payBook(@Param("id") Long id);
}
