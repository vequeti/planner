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
		id = entity.getId();
		travelerId = entity.getTraveler().getId();
		destination = entity.getDestination();
		startsAt = entity.getStartsAt();
		endsAt = entity.getEndsAt();
	}
}