package com.hcl.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ticketbooking.entity.Booking;

@Repository
public interface BookingDetailsRepository extends JpaRepository<Booking, Integer> {

}
