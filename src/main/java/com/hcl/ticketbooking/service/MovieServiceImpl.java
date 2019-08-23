package com.hcl.ticketbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ticketbooking.dto.MovieDTO;
import com.hcl.ticketbooking.entity.Movie;
import com.hcl.ticketbooking.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;

	public List<MovieDTO> movieList() {

		List<MovieDTO> movieDTOList = new ArrayList<>();

		List<Movie> movieList = movieRepository.findAll();

		for (Movie movie : movieList) {

			MovieDTO movieDTO = new MovieDTO();
			movieDTO.setMovieId(movie.getMovieId());
			movieDTO.setMovieName(movie.getMovieName());
			movieDTOList.add(movieDTO);

		}

		return movieDTOList;
	}

}
