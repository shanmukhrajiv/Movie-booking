package com.hcl.ticketbooking.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ticketbooking.dto.MovieDTO;
import com.hcl.ticketbooking.entity.Movie;
import com.hcl.ticketbooking.repository.MovieRepository;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceImplTest {

	@Mock
	MovieRepository movieRepository;

	@InjectMocks
	MovieServiceImpl movieServiceImpl;

	@Test
	public void testMovieList() {

		List<MovieDTO> movieDTOList = new ArrayList<>();

		List<Movie> movieList = new ArrayList<>();

		Movie movie = new Movie();
		movie.setMovieId(1);
		movie.setMovieName("Saaho");
		Movie movie1 = new Movie();

		movie1.setMovieId(2);
		movie1.setMovieName("Mission Mangal");

		movieList.add(movie);
		movieList.add(movie1);

		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setMovieId(1);
		movieDTO.setMovieName("Saaho");

		MovieDTO movieDTO1 = new MovieDTO();
		movieDTO1.setMovieId(1);
		movieDTO1.setMovieName("Saaho");

		movieDTOList.add(movieDTO);
		movieDTOList.add(movieDTO1);

		Mockito.when(movieRepository.findAll()).thenReturn(movieList);

		List<MovieDTO> actualValue = movieServiceImpl.movieList();
		assertEquals(movieDTOList.size(), actualValue.size());

	}

}
