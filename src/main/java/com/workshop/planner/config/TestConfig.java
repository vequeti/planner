package com.workshop.planner.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.workshop.planner.entities.Trip;
import com.workshop.planner.entities.User;
import com.workshop.planner.repositories.TripRepository;
import com.workshop.planner.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private TripRepository tripRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Vinicius Vequeti", "viniciusvequeti@trip.com");
		User u2 = new User(null, "Renato Souza", "renatosouza@trip.com");
		
		Trip t1 = new Trip(null, u1, "Rio de Janeiro", LocalDateTime.of(2024, 2, 1, 10, 0), LocalDateTime.of(2024, 2, 10, 10, 0), false);
		Trip t2 = new Trip(null, u2, "Rio de Janeiro", LocalDateTime.of(2024, 2, 1, 10, 0), LocalDateTime.of(2024, 2, 10, 10, 0), false);

		userRepository.saveAll(Arrays.asList(u1, u2));
		tripRepository.saveAll(Arrays.asList(t1, t2));
	}
}