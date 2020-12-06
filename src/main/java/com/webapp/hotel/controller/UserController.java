package com.webapp.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.hotel.service.UserService;
import com.webapp.hotel.entity.User;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;
	
	// Formulario de login
	@RequestMapping("/login.html")
	public String login() {
	  return "login.html";
	}
  
	// Formulario de login con error
	@RequestMapping("/login-error.html")
	public String loginError(Model model) {
	  model.addAttribute("loginError", true);
	  return "login.html";
	}
	
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return userservice.retrieveAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
	    return userservice.getUser(id);
	}
	
	
	@GetMapping("/users/new")
	public String crearUsuario(Model model){
		model.addAttribute("User", new User());
		return "form";
	}
	
	@PostMapping("/users/new")
	public String addUser(@ModelAttribute User user, Model model) {
		model.addAttribute("User", user);
		user.setRole("USER");
		userservice.addUser(user);
		return "redirect:/login";
	}
	
	@GetMapping("/")
	public String saludo() {
		return "index";
	}
}

@ControllerAdvice

public class ErrorController {

    private static Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(final Throwable throwable, final Model model) {
        logger.error("Exception during execution of SpringSecurity application", throwable);
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

}