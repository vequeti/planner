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
public class UserCreateDTO {
		private Long id;
		private String name;
		private String email;
		
		public UserCreateDTO(User entity) {
			this.id = entity.getId();
			this.name = entity.getName();
			this.email = entity.getEmail();
		}
}
