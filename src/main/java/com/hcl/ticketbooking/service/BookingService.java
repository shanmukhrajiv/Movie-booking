package com.hcl.ticketbooking.service;

import org.springframework.http.ResponseEntity;

import com.hcl.ticketbooking.dto.BookingInput;
import com.hcl.ticketbooking.dto.BookingResponse;
import com.hcl.ticketbooking.dto.BookingStatusUpdateInput;
import com.hcl.ticketbooking.dto.ResponseDto;

public interface BookingService {
	
	public ResponseEntity<BookingResponse> booking(BookingInput bookingInput);
	public ResponseEntity<ResponseDto> bookingStatusUpdate(BookingStatusUpdateInput bookingStatusUpdateInput);


}
