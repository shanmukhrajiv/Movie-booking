package com.hcl.ticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ticketbooking.entity.TheatreSeat;
@Repository
public interface TheatreSeatRepository extends JpaRepository<TheatreSeat, Integer>{
	List<TheatreSeat> findByShowTimingId(Integer showtimingid);

}
