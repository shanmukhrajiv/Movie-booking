package com.hcl.ticketbooking.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ticketbooking.dto.BookingDetailsDTO;
import com.hcl.ticketbooking.entity.Booking;
import com.hcl.ticketbooking.entity.Movie;
import com.hcl.ticketbooking.entity.ShowTimings;
import com.hcl.ticketbooking.entity.Theatre;
import com.hcl.ticketbooking.entity.TheatreSeat;
import com.hcl.ticketbooking.exception.WrongBookingId;
import com.hcl.ticketbooking.repository.BookingDetailsRepository;
import com.hcl.ticketbooking.repository.MovieRepository;
import com.hcl.ticketbooking.repository.ShowTimingsRepository;
import com.hcl.ticketbooking.repository.TheatreRepository;
import com.hcl.ticketbooking.repository.TheatreSeatRepository;

@RunWith(MockitoJUnitRunner.class)
public class BookingDetailsServiceImplTest {

	@Mock
	BookingDetailsRepository bookingDetailsRepository;

	@Mock

	TheatreSeatRepository theatreSeatRepository;

	@Mock
	ShowTimingsRepository ShowTimingsRepository;

	@Mock
	MovieRepository movieRepository;

	@Mock
	TheatreRepository theatreRepository;

	@InjectMocks
	BookingDetailsServiceImpl bookingDetailsServiceImpl;

	@Test
	public void testBookingDetails() {

		BookingDetailsDTO bookingDetailsDTO = new BookingDetailsDTO();
		bookingDetailsDTO.setBookingId(1);
		bookingDetailsDTO.setAmount(1000);
		bookingDetailsDTO.setNoOfTickets(2);
		bookingDetailsDTO.setEmail("raja@gmail.com");
		bookingDetailsDTO.setName("raja");
		bookingDetailsDTO.setStatus("Booked");
		bookingDetailsDTO.setShowDate(LocalDate.now());
		bookingDetailsDTO.setShowTime("2:00 PM");
		bookingDetailsDTO.setMovieName("saaho");
		bookingDetailsDTO.setTheatreName("Tulsi");
		

		Booking booking = new Booking();
		booking.setBookingId(1);
		booking.setEmail("raja@gmail.com");
		booking.setName("raja");
		booking.setStatus("Booked");
		booking.setAmount(1000);
		booking.setBookedSeats(2);
		booking.setTheatreSeatId(1);

		TheatreSeat theatreSeat = new TheatreSeat();
		theatreSeat.setTheatreSeatId(1);
		theatreSeat.setTotalSeats(1);
		theatreSeat.setShowTimingId(1);
		theatreSeat.setAvailableSeats(10);
		theatreSeat.setPrice(100);
		theatreSeat.setSeatCategoryId(1);

		ShowTimings showTime = new ShowTimings();
		showTime.setMovieId(1);
		showTime.setShowDate(LocalDate.now());
		showTime.setShowTime("2:00PM");
		showTime.setShowTimingsId(1);
		showTime.setTheatreId(1);

		Movie movie = new Movie();
		movie.setMovieId(1);
		movie.setMovieName("saaho");
		movie.setMovieLanguage("telugu");
		movie.setMovieRunningTime(180);

		Theatre theatre = new Theatre();
		theatre.setTheatreId(1);
		theatre.setTheatreName("Tulsi");
		theatre.setTheatreAddress("Marathahalli");

		Mockito.when(bookingDetailsRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(booking));

		Mockito.when(theatreSeatRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(theatreSeat));
		Mockito.when(ShowTimingsRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(showTime));

		Mockito.when(movieRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(movie));

		Mockito.when(theatreRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(theatre));

		BookingDetailsDTO actualValue = bookingDetailsServiceImpl.bookingDetails(booking.getBookingId());

		assertEquals(bookingDetailsDTO.getMovieName(), actualValue.getMovieName());

		
	}
	
	@Test(expected=WrongBookingId.class)
	public void testBookingDetailsElse() {

		BookingDetailsDTO bookingDetailsDTO = new BookingDetailsDTO();
		bookingDetailsDTO.setBookingId(1);
		bookingDetailsDTO.setAmount(1000);
		bookingDetailsDTO.setNoOfTickets(2);
		bookingDetailsDTO.setEmail("raja@gmail.com");
		bookingDetailsDTO.setName("raja");
		bookingDetailsDTO.setStatus("Booked");
		bookingDetailsDTO.setShowDate(LocalDate.now());
		bookingDetailsDTO.setShowTime("2:00 PM");
		bookingDetailsDTO.setMovieName("saaho");
		bookingDetailsDTO.setTheatreName("Tulsi");
		

		Booking booking = new Booking();
		booking.setBookingId(1);
		booking.setEmail("raja@gmail.com");
		booking.setName("raja");
		booking.setStatus("Booked");
		booking.setAmount(1000);
		booking.setBookedSeats(2);
		booking.setTheatreSeatId(1);

		TheatreSeat theatreSeat = new TheatreSeat();
		theatreSeat.setTheatreSeatId(1);
		theatreSeat.setTotalSeats(1);
		theatreSeat.setShowTimingId(1);
		theatreSeat.setAvailableSeats(10);
		theatreSeat.setPrice(100);
		theatreSeat.setSeatCategoryId(1);

		ShowTimings showTime = new ShowTimings();
		showTime.setMovieId(1);
		showTime.setShowDate(LocalDate.now());
		showTime.setShowTime("2:00PM");
		showTime.setShowTimingsId(1);
		showTime.setTheatreId(1);

		Movie movie = new Movie();
		movie.setMovieId(1);
		movie.setMovieName("saaho");
		movie.setMovieLanguage("telugu");
		movie.setMovieRunningTime(180);

		Theatre theatre = new Theatre();
		theatre.setTheatreId(1);
		theatre.setTheatreName("Tulsi");
		theatre.setTheatreAddress("Marathahalli");

		//Mockito.when(bookingDetailsRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(booking));

		Mockito.when(theatreSeatRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(theatreSeat));
		Mockito.when(ShowTimingsRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(showTime));

		Mockito.when(movieRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(movie));

		Mockito.when(theatreRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(theatre));

		BookingDetailsDTO actualValue = bookingDetailsServiceImpl.bookingDetails(booking.getBookingId());

		//assertEquals(bookingDetailsDTO.getMovieName(), actualValue.getMovieName());

		
	}



}
