package com.hcl.ticketbooking.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookingResponse {

	private Integer statusCode;
	private String message;
	private Integer bookingId;

}
