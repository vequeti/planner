package com.workshop.planner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.planner.entities.Trip;

public interface TripRepository extends JpaRepository<Trip, Long>{

}
