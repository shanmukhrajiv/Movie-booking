package com.hcl.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ticketbooking.dto.BookingDetailsDTO;
import com.hcl.ticketbooking.service.BookingDetailsServiceImpl;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class BookingDetailsController {

	@Autowired
	BookingDetailsServiceImpl bookingDetailsServiceImpl;

	@GetMapping("/movie/book/{bookingId}")
	public ResponseEntity<BookingDetailsDTO> bookingDetails(@PathVariable Integer bookingId) {

		return new ResponseEntity<>(bookingDetailsServiceImpl.bookingDetails(bookingId),
				HttpStatus.OK);

	}

}
