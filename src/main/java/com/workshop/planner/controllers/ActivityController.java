package com.workshop.planner.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.planner.dto.ActivityDTO;
import com.workshop.planner.services.ActivityService;

@RestController
@RequestMapping(value = "/activities")
public class ActivityController {

	@Autowired
	private ActivityService service;
	
	@GetMapping
	public ResponseEntity<List<ActivityDTO>> findAll(){
		List<ActivityDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ActivityDTO> findById(@PathVariable Long id){
		ActivityDTO act = service.findById(id);
		return ResponseEntity.ok().body(act);
	}
}