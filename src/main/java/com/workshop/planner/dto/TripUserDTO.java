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
public class TripUserDTO {

	private String destination;
	private LocalDateTime startsAt;
	private LocalDateTime endsAt;
	private boolean isConfirmed;
	
	public TripUserDTO (Trip entity) {
		super();
		this.destination = entity.getDestination();
		this.startsAt = entity.getStartsAt();
		this.endsAt = entity.getEndsAt();
		this.isConfirmed = entity.isConfirmed();
	}
}
