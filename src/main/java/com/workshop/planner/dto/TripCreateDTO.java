package com.workshop.planner.dto;

import java.time.LocalDateTime;

import com.workshop.planner.entities.Trip;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripCreateDTO {

	private Long id;
	private Long travelerId;
	private String destination;
	private LocalDateTime startsAt;
	private LocalDateTime endsAt;
	
	public TripCreateDTO (Trip entity) {
		super();
		this.id = entity.getId();
		this.travelerId = entity.getTraveler().getId();
		this.destination = entity.getDestination();
		this.startsAt = entity.getStartsAt();
		this.endsAt = entity.getEndsAt();
	}
}