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
public class ActivityMinDTO {

	private Long id;
	private String title;
	private LocalDateTime occursAt;
	
	public ActivityMinDTO(Activity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.occursAt = entity.getOccursAt();
	}
}