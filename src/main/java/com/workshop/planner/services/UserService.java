package com.workshop.planner.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.workshop.planner.entities.User;
import com.workshop.planner.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		
		return user.get();
	}
}