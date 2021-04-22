package com.webapp.hotel.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webapp.hotel.entity.Room;
//import com.webapp.hotel.entity.Booking;

public interface RoomRepository extends JpaRepository<Room, Long> {
	
	//@Query( "select r from Room r where r in (select b from Booking b where :fechaInicio >= b.checkOut OR :fechaFin <= b.checkIn) and r.occupancy >= :cantPersonas")
	//@Query ( "select r.name from Room r where r.roomId in (select roomId from Booking b left join Room r on b.roomId=r.roomId where :fechaInicio >= b.check_out OR :fechaFin <= b.check_in) and :cantPersonas <= r.occupancy")
	@Query ("Select r From Room r where r.occupancy >= :cantPersonas and r.availability > (Select count(b) From Booking b where b.room = r and b.checkIn between :fechaInicio and :fechaFin and b.isCanceled = 'false')")
	public List<Room> findAvaliblesRooms(
			@Param("fechaInicio") LocalDate fechaInicio,
			@Param("fechaFin") LocalDate fechaFin,
			@Param("cantPersonas") int cantPersonas);
	
	@Query(value="select * from Room", nativeQuery = true)
	public List<Room> findRooms();	
}
/*
 * select r 
 * from Room r 
 * where in 
 * 		(select b 
 * 		from Booking b 
 * 		where :fechaInicio >= checkOut OR :fechaFin <= checkIn;) 
 * and occupancy >= :cantPersonas
 *probando la wea 
 */
 