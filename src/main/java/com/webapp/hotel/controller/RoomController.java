package com.webapp.hotel.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.hotel.entity.Consulta;
import com.webapp.hotel.entity.Room;
import com.webapp.hotel.service.RoomService;

@Controller
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/rooms")
	public List<Room> retriveAllRooms(){
		return roomService.encontrarRooms();
	}

	
	@GetMapping("/rooms/disponibles")
	public String disponibilidad(Consulta consulta, Model model){	
		model.addAttribute("consulta", new Consulta());
		return "roomsavailable";
	}
	
	
	@PostMapping("/rooms/disponibles")
	public String findAvaliableRooms(Consulta consulta, Model model){
		model.addAttribute("room",roomService.findAvaliblesRooms(consulta));
		return "roomsavailableerep";
	}
}
