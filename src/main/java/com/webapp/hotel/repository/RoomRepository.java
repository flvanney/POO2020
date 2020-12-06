package com.webapp.hotel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webapp.hotel.entity.Room;
//import com.webapp.hotel.entity.Booking;

public interface RoomRepository extends JpaRepository<Room, Long> {
	
	/*@Query( "select r from Room r where r in (select b from Booking b where :fechaInicio >= b.checkOut OR :fechaFin <= b.checkIn) and r.occupancy >= :cantPersonas")*/
	@Query ( "select r.name from room r where r.room_id not in (select room_id from booking b natural join room r where :fechaInicio >= b.check_out OR :fechaFin <= b.check_in) and cantPersonas <= r.occupancy")
	public List<Room> findAvaliblesRooms(
			@Param("fechaInicio") Date fechaInicio,
			@Param("fechaFin") Date fechaFin,
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
 