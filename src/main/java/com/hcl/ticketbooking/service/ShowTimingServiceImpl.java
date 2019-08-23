package com.hcl.ticketbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ticketbooking.dto.ShowTimingDetailsDto;
import com.hcl.ticketbooking.entity.ShowTimings;
import com.hcl.ticketbooking.entity.Theatre;
import com.hcl.ticketbooking.entity.TheatreSeat;
import com.hcl.ticketbooking.repository.ShowTimingRepository;
import com.hcl.ticketbooking.repository.TheatreRepository;
import com.hcl.ticketbooking.repository.TheatreSeatRepository;

@Service
public class ShowTimingServiceImpl implements ShowTimingService{

	@Autowired
	ShowTimingRepository showTimingRepository;
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@Autowired
	TheatreSeatRepository theatreSeatRepository;
	
	public List<ShowTimingDetailsDto> theatre(Integer movieId) {
		List<ShowTimingDetailsDto> showTimingDetailsDtos = new ArrayList<ShowTimingDetailsDto>();
		List<ShowTimings> showTimings = showTimingRepository.findByMovieId(movieId);
		
		for(ShowTimings show : showTimings) {
			
			ShowTimingDetailsDto showTimingDetailsDto = new ShowTimingDetailsDto();
			Theatre theatre = theatreRepository.findByTheatreId(show.getMovieId());
			TheatreSeat theatreSeat = theatreSeatRepository.findByShowTimingId(show.getShowTimingsId());
			showTimingDetailsDto.setShowTime(show.getShowTime());
			if(theatreSeat.getAvailableSeats()!=0) {
				showTimingDetailsDto.setAvailableSeats(theatreSeat.getAvailableSeats());
			}
			showTimingDetailsDto.setAvailableSeats(0);
			showTimingDetailsDto.setTheatreId(theatre.getTheatreId());
			showTimingDetailsDto.setTheatreName(theatre.getTheatreName());
			showTimingDetailsDtos.add(showTimingDetailsDto);
		}
		
		return showTimingDetailsDtos;
	}

}
