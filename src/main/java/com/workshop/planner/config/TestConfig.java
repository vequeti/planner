package com.workshop.planner.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.workshop.planner.entities.Activity;
import com.workshop.planner.entities.Trip;
import com.workshop.planner.entities.User;
import com.workshop.planner.repositories.ActivityRepository;
import com.workshop.planner.repositories.TripRepository;
import com.workshop.planner.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private TripRepository tripRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Vinicius Vequeti", "viniciusvequeti@trip.com", null);
		User u2 = new User(null, "Renato Souza", "renatosouza@trip.com", null);

		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Trip t1 = new Trip(null, u1, "Rio de Janeiro", LocalDateTime.of(2024, 2, 1, 10, 0), LocalDateTime.of(2024, 2, 10, 10, 0), false, null);
		Trip t2 = new Trip(null, u2, "Rio de Janeiro", LocalDateTime.of(2024, 2, 1, 10, 0), LocalDateTime.of(2024, 2, 10, 10, 0), false, null);

		tripRepository.saveAll(Arrays.asList(t1, t2));
		
		Activity a1 = new Activity(null, "Visita ao Cristo Redentor", LocalDateTime.of(2024, 2, 3, 16, 0), t1);
		
		activityRepository.saveAll(Arrays.asList(a1));
	}
}