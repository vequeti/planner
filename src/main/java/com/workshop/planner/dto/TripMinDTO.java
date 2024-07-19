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
public class TripMinDTO {

	private Long id;
	private String travelerName;
	private String destination;
	private LocalDateTime startsAt;
	private LocalDateTime endsAt;
	private boolean isConfirmed;
	
	public TripMinDTO (Trip entity) {
		super();
		this.id = entity.getId();
		this.travelerName = entity.getTraveler().getName();
		this.destination = entity.getDestination();
		this.startsAt = entity.getStartsAt();
		this.endsAt = entity.getEndsAt();
		this.isConfirmed = entity.isConfirmed();
	}
}