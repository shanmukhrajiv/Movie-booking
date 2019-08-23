package com.hcl.ticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ticketbooking.dto.ShowTimingDetailsDto;
import com.hcl.ticketbooking.service.ShowTimingService;

@RestController
@RequestMapping("/booking")
public class ShowTimingController {
	
	@Autowired
	ShowTimingService showTimingService;
	
	@GetMapping("/movies/{movieId}")
	public ResponseEntity<List<ShowTimingDetailsDto>> theatre(@PathVariable("movieId") Integer movieId){
		List<ShowTimingDetailsDto> showTimingDetailsDtos = showTimingService.theatre(movieId);
		return new ResponseEntity<List<ShowTimingDetailsDto>>(showTimingDetailsDtos,HttpStatus.OK);
		
	}

}
