package com.hcl.ticketbooking.exception;

public class WrongBookingId extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public WrongBookingId(String message) {

		super(message);

	}

}
