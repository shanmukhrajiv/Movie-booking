package com.hcl.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ticketbooking.entity.TheatreSeat;

public interface TheatreSeatRepository extends JpaRepository<TheatreSeat, Long>{

	public TheatreSeat findByShowTimingId(Integer showTimingsId);

}
