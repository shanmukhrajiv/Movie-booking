package com.hcl.ticketbooking.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class RequestDTO {
	
	private Integer userId;
	private Integer breachId;
	private String action;

}
