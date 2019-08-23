package com.hcl.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ticketbooking.entity.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

}
