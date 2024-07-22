package com.workshop.planner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.planner.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{

	User findByName(String name);
	User findByEmail(String email);
}
