package com.hcl.ticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ticketbooking.dto.BookingInput;
import com.hcl.ticketbooking.dto.BookingResponse;
import com.hcl.ticketbooking.dto.BookingStatusUpdateInput;
import com.hcl.ticketbooking.dto.MovieDTO;
import com.hcl.ticketbooking.dto.ResponseDto;
import com.hcl.ticketbooking.service.BookingService;
import com.hcl.ticketbooking.service.MovieService;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@Autowired
	BookingService bookingService;

	@GetMapping("/movies")
	public ResponseEntity<List<MovieDTO>> movieList() {

		return new ResponseEntity<>(movieService.movieList(), HttpStatus.OK);

	}

	@PostMapping("/movies/book")
	public ResponseEntity<BookingResponse> Booking(@RequestBody BookingInput bookingInput) {
		return bookingService.Booking(bookingInput);

	}

	@PutMapping("/movies/book")
	public ResponseEntity<ResponseDto> BookingStatusUpdate(@RequestBody BookingStatusUpdateInput bookingStatusUpdateInput) {
		return bookingService.BookingStatusUpdate(bookingStatusUpdateInput);

	}

}
