package com.webapp.hotel.entity;

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
@Table(name="Payment")
public class Payment {

		@Id @GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="paymentId")
		private Long id;
		private Date createdAt;
		@OneToOne
		@JoinColumn(name = "BOOKING_ID")
		private Booking booking;
		private String card;
		private String cardNumber;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Booking getBooking() {
			return booking;
		}
		public void setBooking(Booking booking) {
			this.booking = booking;
		}
		public String getCard() {
			return card;
		}
		public void setCard(String card) {
			this.card = card;
		}
		public String getCardNumber() {
			return cardNumber;
		}
		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}
}
