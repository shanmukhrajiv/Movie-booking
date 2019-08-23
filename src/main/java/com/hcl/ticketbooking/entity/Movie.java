package com.hcl.ticketbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class Movie {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)

	private Integer movieId;
	private String movieName;
	private String movieLanguage;
	private Integer movieRunningTime;

}
