package com.webapp.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.hotel.entity.Room;
import com.webapp.hotel.service.RoomService;

@RestController
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/rooms")
	public List<Room> retriveAllRooms(){
		return roomService.encontrarRooms();
	}

}
