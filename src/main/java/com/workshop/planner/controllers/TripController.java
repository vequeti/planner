package com.workshop.planner.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.planner.dto.TripCreateDTO;
import com.workshop.planner.dto.TripDTO;
import com.workshop.planner.dto.TripMinDTO;
import com.workshop.planner.entities.Trip;
import com.workshop.planner.services.TripService;

@RestController
@RequestMapping(value = "/trips")
public class TripController {

	@Autowired
	private TripService service;
	
	@GetMapping
	public ResponseEntity<List<TripMinDTO>> findAll(){
		List<TripMinDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TripDTO> findById(@PathVariable Long id){
		TripDTO trip = service.findById(id);
		return ResponseEntity.ok().body(trip);
	}
	
	@PostMapping
	public ResponseEntity<TripCreateDTO> insert(@RequestBody TripCreateDTO trip){
		trip = service.insert(trip);
		return ResponseEntity.ok(trip);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip trip){
		trip = service.update(id, trip);
		return ResponseEntity.ok().body(trip);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTrip(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}