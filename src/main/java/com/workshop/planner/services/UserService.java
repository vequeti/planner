package com.workshop.planner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.workshop.planner.dto.UserCreateDTO;
import com.workshop.planner.dto.UserDTO;
import com.workshop.planner.entities.User;
import com.workshop.planner.repositories.UserRepository;
import com.workshop.planner.services.exceptions.DatabaseException;
import com.workshop.planner.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<UserDTO> findAll(){
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).toList();
	}
	
	public UserDTO findById(Long id) {
		try {
			User user = repository.findById(id).get();
			return new UserDTO(user);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public UserCreateDTO insert(UserCreateDTO obj) {
		User user = new User();
		
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
		
		user = repository.save(user);
		return new UserCreateDTO(user);
	}
	
	public User update(Long id, User user) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, user);
			return repository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateData(User entity, User user) {
		if(user.getName() != null) {
			entity.setName(user.getName());
		}
		if(user.getEmail() != null) {
			entity.setEmail(user.getEmail());
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User findByName(String name){
		User user = repository.findByName(name);
		return user;
	}
}