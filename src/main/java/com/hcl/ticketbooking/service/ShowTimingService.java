package com.hcl.ticketbooking.service;

import java.util.List;

import com.hcl.ticketbooking.dto.ShowTimingDetailsDto;

public interface ShowTimingService {
	public List<ShowTimingDetailsDto> theatre(Integer movieId);
}
