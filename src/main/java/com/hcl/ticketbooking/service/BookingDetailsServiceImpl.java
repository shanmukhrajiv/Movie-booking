package com.hcl.ticketbooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

	@Autowired
	BookingDetailsRepository bookingDetailsRepository;

	@Autowired
	TheatreSeatRepository theatreSeatRepository;

	@Autowired
	ShowTimingsRepository ShowTimingsRepository;

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	TheatreRepository theatreRepository;

	@Override
	public BookingDetailsDTO bookingDetails(Integer bookingId) {
		

		BookingDetailsDTO bookingDetailsDTO = new BookingDetailsDTO();

		Optional<Booking> optBooking = bookingDetailsRepository.findById(bookingId);

		if (optBooking.isPresent()) {
			Booking booking = optBooking.get();

			bookingDetailsDTO.setBookingId(booking.getBookingId());
			bookingDetailsDTO.setAmount(booking.getAmount());
			bookingDetailsDTO.setNoOfTickets(booking.getBookedSeats());
			bookingDetailsDTO.setEmail(booking.getEmail());
			bookingDetailsDTO.setName(booking.getName());
			bookingDetailsDTO.setStatus(booking.getStatus());
			Integer theatreSeatId = booking.getTheatreSeatId();

			Optional<TheatreSeat> optTheatreSeat = theatreSeatRepository.findById(theatreSeatId);

			if (optTheatreSeat.isPresent()) {

				TheatreSeat theatreSeat = optTheatreSeat.get();

				Integer theatreSeats = theatreSeat.getTheatreSeatId();

				Optional<ShowTimings> optShowTiming = ShowTimingsRepository.findById(theatreSeats);

				if (optShowTiming.isPresent()) {
					ShowTimings showTime = optShowTiming.get();
					bookingDetailsDTO.setShowDate(showTime.getShowDate());
					bookingDetailsDTO.setShowTime(showTime.getShowTime());

					Integer movieId = showTime.getMovieId();
					Integer theatreId = showTime.getTheatreId();
					Optional<Movie> optMovie = movieRepository.findById(movieId);

					if (optMovie.isPresent()) {
						Movie movie = optMovie.get();
						bookingDetailsDTO.setMovieName(movie.getMovieName());

						Optional<Theatre> optTheatre = theatreRepository.findById(theatreId);
						if (optTheatre.isPresent()) {
							Theatre threatre = optTheatre.get();
							bookingDetailsDTO.setTheatreName(threatre.getTheatreName());

						}
 
					}

				}

			}

		}

		else {

			throw new WrongBookingId("No bookings Found with given BookingId");
		}

		return bookingDetailsDTO;
	}

}
