package com.hcl.ticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ticketbooking.entity.ShowTimings;

@Repository
public interface ShowTimingRepository extends JpaRepository<ShowTimings, Long>{

	public List<ShowTimings> findByMovieId(Integer movieId);

}
