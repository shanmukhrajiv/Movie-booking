package com.hcl.ticketbooking.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class BookingInput {
	
	private Integer showTimingId;
	private Integer noOfSeats;
	private String name;
	private Long mobileNo;
	private String email;
	

}
