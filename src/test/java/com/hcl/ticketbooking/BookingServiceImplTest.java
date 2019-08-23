package com.hcl.ticketbooking;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.ticketbooking.dto.BookingInput;
import com.hcl.ticketbooking.dto.BookingResponse;
import com.hcl.ticketbooking.dto.BookingStatusUpdateInput;
import com.hcl.ticketbooking.dto.ResponseDto;
import com.hcl.ticketbooking.entity.Booking;
import com.hcl.ticketbooking.entity.TheatreSeat;
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

	@Before
	public void setUp() {
		
		

	}
	
	@Test
	public void BookingTest()
	{
//		List<TheatreSeat> theatreSeat = theatreSeatRepository.findByShowTimingId(bookingInput.getShowTimingId());
//		booking = bookingRepository.save(booking);

		
		
	}
	
	@Test
	public void BookingStatusUpdateTest() {
		
//		Optional<Booking> booking = bookingRepository.findById(bookingStatusUpdateInput.getBookingId());
		
//		bookingRepository.save(booking.get());

	}



}
