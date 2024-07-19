package com.workshop.planner.dto;

import java.util.ArrayList;
import java.util.List;

import com.workshop.planner.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private Long id;
	private String name;
	private String email;
	
	private List<TripUserDTO> trips = new ArrayList<>();
	
	public UserDTO (User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		
		entity.getTrips().forEach(trip -> this.trips.add(new TripUserDTO(trip)));
	}
}
