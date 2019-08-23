package com.hcl.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ticketbooking.entity.ShowTimings;


public interface ShowTimingsRepository extends JpaRepository<ShowTimings, Integer> {

}
