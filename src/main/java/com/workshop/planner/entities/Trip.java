package com.workshop.planner.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Trip implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User traveler;
	
	private String destination;
	
	@Column(name = "starts_at")
	private LocalDateTime startsAt;
	
	@Column(name = "ends_at")
	private LocalDateTime endsAt;
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
	@OneToMany(mappedBy = "trip")
	private List<Activity> activities = new ArrayList<>();

}