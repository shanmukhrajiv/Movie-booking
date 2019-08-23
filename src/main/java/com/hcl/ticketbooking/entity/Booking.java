package com.hcl.ticketbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class Booking {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)

	
	private Integer bookingId;
	private Integer theatreSeatId;
	private Integer bookedSeats;
	private Integer amount;
	private String status;
	private String name;
	private String email;
	

}
