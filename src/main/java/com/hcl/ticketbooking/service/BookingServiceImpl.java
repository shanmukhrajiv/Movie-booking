package com.hcl.ticketbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.ticketbooking.dto.BookingInput;
import com.hcl.ticketbooking.dto.BookingResponse; 
import com.hcl.ticketbooking.dto.BookingStatusUpdateInput;
import com.hcl.ticketbooking.dto.EbookingStatus;
import com.hcl.ticketbooking.dto.ResponseDto;
import com.hcl.ticketbooking.entity.Booking;
import com.hcl.ticketbooking.entity.TheatreSeat;
import com.hcl.ticketbooking.exception.MovieException;
import com.hcl.ticketbooking.repository.BookingRepository;
import com.hcl.ticketbooking.repository.ShowTimingsRepository;
import com.hcl.ticketbooking.repository.TheatreSeatRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	ShowTimingsRepository showTimingsRepository;
	@Autowired
	TheatreSeatRepository theatreSeatRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Override
	public ResponseEntity<BookingResponse> Booking(BookingInput bookingInput) {

//		
		Booking booking = new Booking();

		List<TheatreSeat> theatreSeat = theatreSeatRepository.findByShowTimingId(bookingInput.getShowTimingId());

		if(theatreSeat.isEmpty())
			throw new MovieException("no show availabe");
		
		if(theatreSeat.get(0).getAvailableSeats()<bookingInput.getNoOfSeats())
			throw new MovieException("all seats are filled");

		
		booking.setAmount((bookingInput.getNoOfSeats() * theatreSeat.get(0).getPrice()));
		booking.setEmail(bookingInput.getEmail());
		booking.setName(bookingInput.getName());
		booking.setStatus(EbookingStatus.PENDING.name());
		booking.setBookedSeats(bookingInput.getNoOfSeats());
		booking.setTheatreSeatId(theatreSeat.get(0).getTheatreSeatId());
 
		
		bookingRepository.save(booking);
		
		theatreSeat.get(0).setAvailableSeats(theatreSeat.get(0).getAvailableSeats()-bookingInput.getNoOfSeats());
		theatreSeatRepository.save(theatreSeat.get(0));

		BookingResponse bookingResponse = new BookingResponse();
		bookingResponse.setBookingId(booking.getBookingId());
		bookingResponse.setMessage("booking succsess"); 
		bookingResponse.setStatusCode(HttpStatus.CREATED.value());
		return ResponseEntity.status(HttpStatus.CREATED).body(bookingResponse);

	}

	@Override
	public ResponseEntity<ResponseDto> BookingStatusUpdate(BookingStatusUpdateInput bookingStatusUpdateInput) {
		Optional<Booking> booking = bookingRepository.findById(bookingStatusUpdateInput.getBookingId());

		if (!booking.isPresent())
			throw new MovieException("no booking available");

		if ((!EbookingStatus.BOOKED.name().equalsIgnoreCase(bookingStatusUpdateInput.getStatus()))
				&& (!EbookingStatus.CANCEL.name().equalsIgnoreCase(bookingStatusUpdateInput.getStatus())))
			throw new MovieException("status miss match");

		booking.get().setStatus(bookingStatusUpdateInput.getStatus().toUpperCase());

		bookingRepository.save(booking.get());

		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(bookingStatusUpdateInput.getStatus().toUpperCase()+"  succsessfully");
		responseDto.setStatusCode(HttpStatus.CREATED.value());
		return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);

	}

}
