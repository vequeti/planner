package com.workshop.planner.dto;

import java.time.LocalDateTime;

import com.workshop.planner.entities.Activity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {
	
	private Long id;
	private String title;
	private LocalDateTime occursAt;
	private String trip;
	private String tripOwner;
	
	public ActivityDTO(Activity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.occursAt = entity.getOccursAt();
		this.trip = entity.getTrip().getDestination();
		this.tripOwner = entity.getTrip().getTraveler().getName();
	}
}
