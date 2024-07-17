package com.workshop.planner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.planner.entities.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long>{

}