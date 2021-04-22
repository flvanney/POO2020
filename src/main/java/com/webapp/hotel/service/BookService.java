package com.webapp.hotel.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.webapp.hotel.entity.Booking;
import com.webapp.hotel.entity.Cancelacion;
import com.webapp.hotel.entity.Room;
import com.webapp.hotel.repository.BookRepository;
import com.webapp.hotel.repository.CancelationRepository;

@Service
public class BookService {
	
	@Autowired 
	private BookRepository bookRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private CancelationRepository cancelationRepository;
	
	public void addBook(Booking book, Room room) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
		  book.setGuest(userService.findUserByUsername(username));
		} else {
		 String username = principal.toString();
		 book.setGuest(userService.findUserByUsername(username));
		}
		book.setRoom(room);
		book.setCreatedAt(new Date());
		book.setPaid(false);
		book.setCanceled(false);
		book.setCost(this.calcularPrecio(roomService.getPricebyid(room.getId()), book.isBreakfastIncluded(), book.isParking(), book.isFreeCancelation(), ChronoUnit.DAYS.between(book.getCheckIn(), book.getCheckOut())));
		bookRepository.save(book);
	}
	
	public List<Booking> allBooksbyUserid(Long id){
		return bookRepository.findAllbyUserid(id);
	}

	public float calcularPrecio(Float cost, boolean breakfastIncluded, boolean parking, boolean freeCancelation, long dias) {
		Float extras = 0.0f;
		Float costototal = 0.0f;
		if (breakfastIncluded = true);
			extras += Booking.BREAKFASTCOST;
		if (parking = true);
			extras += Booking.PARKINGCOST;
		if (freeCancelation = true);
			extras += Booking.FREECANCELATIONCOST;
		costototal = (cost+extras)*dias;
		return costototal;
	}
	
	public Booking getBook(Long id) {
	    return bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}
	
	public void payBook(Booking book) {
		bookRepository.payBook(book.getId());
	}
	
	public void addCancelation(Booking book) {
		LocalDate lt = LocalDate.now();
		Cancelacion cancelation = new Cancelacion();
		cancelation.setCreatedAt(lt);
		cancelation.setBooking(book);
		cancelationRepository.save(cancelation);
		bookRepository.cancelBook(book.getId());
	}
}
