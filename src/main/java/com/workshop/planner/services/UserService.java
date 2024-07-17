package com.workshop.planner.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.planner.dto.UserDTO;
import com.workshop.planner.entities.User;
import com.workshop.planner.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<UserDTO> findAll(){
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).toList();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		
		return user.get();
	}
}