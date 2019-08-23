package com.hcl.ticketbooking;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.ticketbooking.controller.MovieController;
import com.hcl.ticketbooking.dto.BookingInput;
import com.hcl.ticketbooking.entity.Movie;
import com.hcl.ticketbooking.service.BookingServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class MovieControllerTest {
	
	@InjectMocks
	MovieController movieController;
	
	@Mock
	BookingServiceImpl bookingServiceImpl;
	
	MockMvc mockMvc;
	Movie  movie;
	String jsonObject;
	
	BookingInput bookingInput;
	
	@Before
	public void setup() throws JsonProcessingException {
		mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
	
	
		ObjectMapper objectMapper = new ObjectMapper();
		 jsonObject = objectMapper.writeValueAsString(bookingInput);
		
	}

	

	
	@Test
	public void bookingTst() throws Exception {

		try {
			mockMvc.perform(post("/movies/book").contentType(MediaType.APPLICATION_JSON).content(jsonObject)).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void bookingStatusUpdateTest() 
	{

		try {
			mockMvc.perform(put("/movies/book").contentType(MediaType.APPLICATION_JSON).content(jsonObject)).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
}
