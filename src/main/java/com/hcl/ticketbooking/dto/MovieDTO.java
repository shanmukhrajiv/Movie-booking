package com.hcl.ticketbooking.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer movieId;
	private String movieName;
//	private String movieLanguage;
//	private Integer movieRunningTime;

}
