package com.workshop.planner.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.planner.dto.TripDTO;
import com.workshop.planner.entities.Trip;
import com.workshop.planner.repositories.TripRepository;

@Service
public class TripService {

	@Autowired
	private TripRepository repository;
	
	public List<TripDTO> findAll(){
		List<Trip> list = repository.findAll();
		return list.stream().map(x -> new TripDTO(x)).toList();
	}
	
	public Trip findById (Long id) {
		Optional<Trip> trip = repository.findById(id);
		
		return trip.get();
	}
}