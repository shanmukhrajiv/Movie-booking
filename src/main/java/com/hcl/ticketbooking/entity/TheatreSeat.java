package com.hcl.ticketbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class TheatreSeat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer theatreSeatId;
	private Integer showTimingId;
	private Integer seatCategoryId;
	private Integer price;
	private Integer totalSeats;
	private Integer availableSeats;

}
