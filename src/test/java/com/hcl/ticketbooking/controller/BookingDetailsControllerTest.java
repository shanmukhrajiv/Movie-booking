package com.hcl.ticketbooking.controller;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.ticketbooking.service.BookingDetailsServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BookingDetailsControllerTest extends BookingDetailsController {

	@Mock
	BookingDetailsServiceImpl bookingDetailsServiceImpl;

	@InjectMocks
	BookingDetailsController bookingDetailsController;

	MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(bookingDetailsController).build();
	}

	@Test
	public void testBookingDetails() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/movie/book/{bookingId}",1).contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL))
				.andExpect(status().isOk());
	}

}
