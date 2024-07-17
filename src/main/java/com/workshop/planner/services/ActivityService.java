package com.workshop.planner.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.planner.dto.ActivityDTO;
import com.workshop.planner.entities.Activity;
import com.workshop.planner.repositories.ActivityRepository;

@Service
public class ActivityService {

	@Autowired
	private ActivityRepository repository;
	
	public List<ActivityDTO> findAll(){
		List<Activity> list = repository.findAll();
		return list.stream().map(x -> new ActivityDTO(x)).toList();
	}
	
	public Activity findById(Long id) {
		Optional<Activity> act = repository.findById(id);
		
		return act.get();
	}
}
