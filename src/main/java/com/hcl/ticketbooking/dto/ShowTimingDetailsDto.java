package com.hcl.ticketbooking.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ShowTimingDetailsDto implements Serializable{

	private static final long serialVersionUID = -3194924233626314376L;
	
	private Integer theatreId;
	private String theatreName;
	private Integer showTimingId;
	private String showTime;
	private Integer availableSeats;

}
