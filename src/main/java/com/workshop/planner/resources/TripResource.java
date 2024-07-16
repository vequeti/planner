package com.workshop.planner.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.planner.entities.Trip;
import com.workshop.planner.services.TripService;

@RestController
@RequestMapping(value = "/trips")
public class TripResource {

	@Autowired
	private TripService service;
	
	@GetMapping
	public ResponseEntity<List<Trip>> findAll(){
		List<Trip> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Trip> findById(@PathVariable Long id){
		Trip trip = service.findById(id);
		
		return ResponseEntity.ok().body(trip);
	}
}