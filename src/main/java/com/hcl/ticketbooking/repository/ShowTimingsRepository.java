package com.hcl.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ticketbooking.entity.ShowTimings;

@Repository
public interface ShowTimingsRepository extends JpaRepository<ShowTimings, Integer> {

}
