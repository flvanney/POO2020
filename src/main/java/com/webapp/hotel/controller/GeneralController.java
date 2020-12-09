package com.webapp.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {
	
	@GetMapping("/")
	public String saludo() {
		return "index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}

}
