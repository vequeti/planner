package com.workshop.planner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.planner.dto.ActivityCreateDTO;
import com.workshop.planner.dto.ActivityDTO;
import com.workshop.planner.entities.Activity;
import com.workshop.planner.entities.Trip;
import com.workshop.planner.repositories.ActivityRepository;
import com.workshop.planner.repositories.TripRepository;
import com.workshop.planner.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ActivityService {

	@Autowired
	private ActivityRepository repository;
	
	@Autowired
	private TripRepository tripRepository;
	
	public List<ActivityDTO> findAll(){
		List<Activity> list = repository.findAll();
		return list.stream().map(x -> new ActivityDTO(x)).toList();
	}
	
	public ActivityDTO findById(Long id) {
		try{
			Activity trip = repository.findById(id).get();
			return new ActivityDTO(trip);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public ActivityCreateDTO insert(ActivityCreateDTO obj) {
		Activity act = new Activity();
		
		act.setTitle(obj.getTitle());
		act.setOccursAt(obj.getOccursAt());
		
		try {
			Trip trip = tripRepository.findById(obj.getTripId()).get();
			act.setTrip(trip);;
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(obj.getTripId());
		}
		
		act = repository.save(act);
		
		return new ActivityCreateDTO(act);
	}
}
