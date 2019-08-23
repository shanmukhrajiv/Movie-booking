package com.hcl.ticketbooking.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class BookingStatusUpdateInput {
	
	
	private Integer bookingId;
	private String status;
	

}
