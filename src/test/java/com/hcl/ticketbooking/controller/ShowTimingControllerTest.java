package com.hcl.ticketbooking.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.ticketbooking.dto.ShowTimingDetailsDto;
import com.hcl.ticketbooking.service.ShowTimingService;

@RunWith(SpringJUnit4ClassRunner.class)
public class ShowTimingControllerTest {

	
	@Mock
	ShowTimingService showTimingService;
	
	@InjectMocks
	ShowTimingController showTimingControllerTest;
	
	ShowTimingDetailsDto showTimingDetailsDto = null;
	List<ShowTimingDetailsDto> showTimingDetailsDtos = null;
	
	@Before
	public void setUp() {
		showTimingDetailsDto = new ShowTimingDetailsDto();
		showTimingDetailsDto.setAvailableSeats(20);
		showTimingDetailsDtos = new ArrayList<ShowTimingDetailsDto>();
		showTimingDetailsDtos.add(showTimingDetailsDto);
	}
	
	@Test
	public void theatresTest() {
		Mockito.when(showTimingService.theatre(2)).thenReturn(showTimingDetailsDtos);
		ResponseEntity<List<ShowTimingDetailsDto>> viewInvitationDtoRes = showTimingControllerTest.theatre(2);
		List<ShowTimingDetailsDto> showTimingDetails = viewInvitationDtoRes.getBody();
		assertEquals(1, showTimingDetails.size());
	}
}
