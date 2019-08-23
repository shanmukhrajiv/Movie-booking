package com.hcl.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ticketbooking.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
