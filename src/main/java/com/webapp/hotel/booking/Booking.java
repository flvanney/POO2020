package com.webapp.hotel.booking;

import com.webapp.hotel.User.*;
import com.webapp.hotel.Room.*;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="Booking")

public class Booking {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="bookingId")
	private Long id;
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User guest;
    private Date checkIn;
    private Date checkOut;
    private Date createdAt;
    @OneToOne
    @JoinColumn(name = "ROOM_ID")
    private Room room;
    private boolean breakfastIncluded;
    private boolean parking;
    private boolean freeCancelation;
    private Float cost;
	
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getGuest() {
		return guest;
	}
	public void setGuest(User guest) {
		this.guest = guest;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Room getRoom() { 
		return room; 
	} 
	
	public void setRoom(Room room) {
		this.room = room; 
	  }
	 
	public boolean isBreakfastIncluded() {
		return breakfastIncluded;
	}
	public void setBreakfastIncluded(boolean breakfastIncluded) {
		this.breakfastIncluded = breakfastIncluded;
	}
	public boolean isParking() {
		return parking;
	}
	public void setParking(boolean parking) {
		this.parking = parking;
	}
	public boolean isFreeCancelation() {
		return freeCancelation;
	}
	public void setFreeCancelation(boolean freeCancelation) {
		this.freeCancelation = freeCancelation;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}

	
}
