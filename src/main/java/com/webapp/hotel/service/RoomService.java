package com.webapp.hotel.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.hotel.entity.Consulta;
import com.webapp.hotel.entity.Room;
import com.webapp.hotel.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	public List<Room> retriveallRooms(){
		return roomRepository.findAll();
	}
	
	public Room getRoom(Long id) {
	    return roomRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}
	
	public List<Room> findAvaliblesRooms(Consulta consulta){
		return roomRepository.findAvaliblesRooms(consulta.getFechaInicio(), consulta.getFechaFin(), consulta.getCantPersonas());
		
	}
	
	public Float getPricebyid (Long id) {
		return getRoom(id).getPrice();
	}
}
