package com.hcl.ticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ticketbooking.dto.MovieDTO;
import com.hcl.ticketbooking.service.MovieService;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@GetMapping("/movies")
	public ResponseEntity<List<MovieDTO>> movieList() {

		return new ResponseEntity<>(movieService.movieList(), HttpStatus.OK);

	}

}
