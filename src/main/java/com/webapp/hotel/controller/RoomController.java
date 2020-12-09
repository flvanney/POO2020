package com.webapp.hotel.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.hotel.entity.Booking;
import com.webapp.hotel.entity.Consulta;
import com.webapp.hotel.entity.Room;
import com.webapp.hotel.entity.User;
import com.webapp.hotel.service.BookService;
import com.webapp.hotel.service.RoomService;

@Controller
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/rooms")
	public List<Room> retriveAllRooms(){
		return roomService.retriveallRooms();
	}

	
	@GetMapping("/rooms/disponibles")
	public String disponibilidad(Model model){	
		model.addAttribute("consulta", new Consulta());
		return "roomsavailable";
	}
	
	@PostMapping("/rooms/disponibles")
	public String findAvaliableRooms(@ModelAttribute Consulta consulta, Model model){
		model.addAttribute("consulta", consulta);
		List<Room> habitaciones = roomService.findAvaliblesRooms(consulta);
		model.addAttribute("room", habitaciones);
		return "roomsavailableerep";
	}
	
	@GetMapping("/rooms/{id}")
	public String bookaRoom(@PathVariable Long id, Model model) {
		model.addAttribute("Booking", new Booking());
		model.addAttribute("Room", roomService.getRoom(id));
		return "booking-form";
	}
	
	@PostMapping("/rooms/{id}")
	public String addBook(@ModelAttribute Booking booking, Room room, Model model) {
		model.addAttribute("Booking", booking);
		//model.addAttribute("Room", room);
		booking.setRoom(room);
		booking.setCreatedAt(new Date());
		bookService.addBook(booking);
		return "booking-success";
	}
	
}
