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
public class ActivityCreateDTO {
	
	private Long id;
	private String title;
	private LocalDateTime occursAt;
	private Long tripId;

	public ActivityCreateDTO(Activity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.occursAt = entity.getOccursAt();
		this.tripId = entity.getTrip().getId();
	}
}
