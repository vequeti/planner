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
public class TripDTO {

	private Long id;
	private String travelerName;
	private String destination;
	private LocalDateTime startsAt;
	private LocalDateTime endsAt;
	private boolean isConfirmed;
	
	public TripDTO (Trip entity) {
		super();
		id = entity.getId();
		travelerName = entity.getTraveler().getName();
		destination = entity.getDestination();
		startsAt = entity.getStartsAt();
		endsAt = entity.getEndsAt();
		isConfirmed = entity.isConfirmed();
	}
}
