package com.hcl.ticketbooking.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookingDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer bookingId;
	private String movieName;
	private String theatreName;
	private LocalDate showDate;
	private String showTime;
	private Integer noOfTickets;
	private Integer amount;
	private String name;
	private String email;
	private String status;
	private Long mobileNo;

}
