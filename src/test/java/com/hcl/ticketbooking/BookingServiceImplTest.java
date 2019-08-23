package com.hcl.ticketbooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
import com.hcl.ticketbooking.service.BookingServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BookingServiceImplTest {

	@InjectMocks
	BookingServiceImpl bookingServiceImpl;
	@Mock
	ShowTimingsRepository showTimingsRepository;
	@Mock
	TheatreSeatRepository theatreSeatRepository;

	@Mock
	BookingRepository bookingRepository;

	BookingInput bookingInput;
	List<BookingInput> bookingInputList;

	TheatreSeat theatreSeat;
	List<TheatreSeat> theatreSeatList;
	Booking booking;
	List<Booking> bookingList;

	BookingStatusUpdateInput bookingStatusUpdateInput;

	@Before
	public void setUp() {
		bookingInput = new BookingInput();
		bookingInput.setEmail("isdguiae");
		bookingInput.setMobileNo(4567345678L);
		bookingInput.setName("sai");
		bookingInput.setNoOfSeats(4);
		bookingInput.setShowTimingId(1);

		bookingInputList = new ArrayList<>();
		bookingInputList.add(bookingInput);

		theatreSeat = new TheatreSeat();
		theatreSeat.setAvailableSeats(20);
		theatreSeat.setPrice(100);
		theatreSeat.setSeatCategoryId(1);
		theatreSeat.setShowTimingId(1);
		theatreSeat.setTheatreSeatId(1);
		theatreSeat.setTotalSeats(100);

		theatreSeatList = new ArrayList<>();
		theatreSeatList.add(theatreSeat);

		booking = new Booking();
		booking.setAmount(400);
		booking.setBookedSeats(bookingInput.getNoOfSeats());
		booking.setBookingId(1);
		booking.setEmail(bookingInput.getEmail());
		booking.setName(bookingInput.getName());
		booking.setStatus(EbookingStatus.PENDING.name());
		booking.setTheatreSeatId(theatreSeat.getTheatreSeatId());

		bookingList = new ArrayList<>();
		bookingList.add(booking);

		bookingStatusUpdateInput = new BookingStatusUpdateInput();
		bookingStatusUpdateInput.setBookingId(1);
		bookingStatusUpdateInput.setStatus(EbookingStatus.BOOKED.name());

	}

	@Test
	public void BookingTest() {
		Mockito.when(theatreSeatRepository.findByShowTimingId(Mockito.anyInt())).thenReturn(theatreSeatList);
		// Mockito.when(bookingRepository.save(booking)).thenReturn(booking);
		
		Mockito.when(theatreSeatRepository.save(theatreSeat)).thenReturn(theatreSeat);


		ResponseEntity<BookingResponse> actual = bookingServiceImpl.Booking(bookingInput);

		Assert.assertEquals(HttpStatus.CREATED.value(), actual.getStatusCodeValue());

	}
	
	@Test(expected = MovieException.class)
	public void BookingTestNegative() {
//		Mockito.when(theatreSeatRepository.findByShowTimingId(Mockito.anyInt())).thenReturn(theatreSeatList);
		// Mockito.when(bookingRepository.save(booking)).thenReturn(booking);
		
//		Mockito.when(theatreSeatRepository.save(theatreSeat)).thenReturn(theatreSeat);


		ResponseEntity<BookingResponse> actual = bookingServiceImpl.Booking(bookingInput);


	}
	
	
	@Test(expected = MovieException.class)
	public void BookingTestNegative2() {
		theatreSeat.setAvailableSeats(1);
		Mockito.when(theatreSeatRepository.findByShowTimingId(Mockito.anyInt())).thenReturn(theatreSeatList);
		// Mockito.when(bookingRepository.save(booking)).thenReturn(booking);
		
//		Mockito.when(theatreSeatRepository.save(theatreSeat)).thenReturn(theatreSeat);


		ResponseEntity<BookingResponse> actual = bookingServiceImpl.Booking(bookingInput);


	}

	@Test
	public void BookingStatusUpdateTest() {

		Mockito.when(bookingRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(booking));
		Mockito.when(bookingRepository.save(booking)).thenReturn(booking);

		ResponseEntity<ResponseDto> actual = bookingServiceImpl.BookingStatusUpdate(bookingStatusUpdateInput);

		Assert.assertEquals(HttpStatus.CREATED.value(), actual.getStatusCodeValue());

	}

	@Test(expected = MovieException.class)
	public void BookingStatusUpdateTestNegative() {

//		Mockito.when(bookingRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(booking));
//		Mockito.when(bookingRepository.save(booking)).thenReturn(booking);

		bookingServiceImpl.BookingStatusUpdate(bookingStatusUpdateInput);

	} 

	@Test(expected = MovieException.class)
	public void BookingStatusUpdateTestNegative2() {
		bookingStatusUpdateInput.setStatus("aydfgih");
		Mockito.when(bookingRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(booking));
//		Mockito.when(bookingRepository.save(booking)).thenReturn(booking);

		bookingServiceImpl.BookingStatusUpdate(bookingStatusUpdateInput);

	}

}
