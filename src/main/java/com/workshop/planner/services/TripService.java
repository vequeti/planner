package com.workshop.planner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.workshop.planner.dto.TripCreateDTO;
import com.workshop.planner.dto.TripDTO;
import com.workshop.planner.dto.TripMinDTO;
import com.workshop.planner.entities.Trip;
import com.workshop.planner.entities.User;
import com.workshop.planner.repositories.TripRepository;
import com.workshop.planner.repositories.UserRepository;
import com.workshop.planner.services.exceptions.DatabaseException;
import com.workshop.planner.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class TripService {

	@Autowired
	private TripRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<TripMinDTO> findAll(){
		List<Trip> list = repository.findAll();
		return list.stream().map(x -> new TripMinDTO(x)).toList();
	}
	
	public TripDTO findById (Long id) {
		try{
			Trip trip = repository.findById(id).get();
			return new TripDTO(trip);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	@Transactional
	public TripCreateDTO insert(TripCreateDTO obj) {
		Trip trip = new Trip();
		
		trip.setDestination(obj.getDestination());
		
		User user = userRepository.findById(obj.getTravelerId()).get();
		trip.setTraveler(user);
		
		
		trip.setStartsAt(obj.getStartsAt());
		trip.setEndsAt(obj.getEndsAt());
		trip.setConfirmed(false);
		
		trip = repository.save(trip);
		
		return new TripCreateDTO(trip);
	}
	
	public Trip update(Long id, Trip trip) {
		try {
			Trip entity = repository.getReferenceById(id);
			updateData(entity, trip);
			return repository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateData(Trip entity, Trip trip) {
		if(trip.getDestination() != null) {
			entity.setDestination(trip.getDestination());
		}
		if(trip.getStartsAt() != null) {
			entity.setStartsAt(trip.getStartsAt());
		}
		if(trip.getEndsAt() != null) {
			entity.setEndsAt(trip.getEndsAt());
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
}