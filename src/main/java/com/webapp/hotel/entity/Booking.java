package com.webapp.hotel.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name="Booking")

public class Booking {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="bookingId")
	private Long id;
    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName="userId")
    private User guest;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkIn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")	
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "ROOM_ID", referencedColumnName="roomId")
    private Room room;
    private boolean breakfastIncluded;
    private boolean parking;
    private boolean freeCancelation;
    private boolean isPaid;
	private boolean isCanceled;
    private Float cost;
    
    //buscar por ignore en jpa
	public static final Float BREAKFASTCOST = 100.00f; //Costos como variables estaticas
    public static final Float PARKINGCOST = 100.00f;
    public static final Float FREECANCELATIONCOST = 500.00f;
    
    
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
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDate checkOut) {
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
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
    public boolean isCanceled() {
		return isCanceled;
	}
	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}
}
