package com.hcl.ticketbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class SeatCategory {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)

	
	private Integer seatCategoryId;
	private String seatCategoryName;


}
