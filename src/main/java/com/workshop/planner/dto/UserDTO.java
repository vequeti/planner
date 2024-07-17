package com.workshop.planner.dto;

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
	
	public UserDTO (User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
	}
}
