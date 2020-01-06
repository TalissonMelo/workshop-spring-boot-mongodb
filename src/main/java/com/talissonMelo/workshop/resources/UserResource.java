package com.talissonMelo.workshop.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talissonMelo.workshop.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {

		User alex = new User("1", "Alex Green", "alex@gmail.com");
		User tales = new User("2", "Talisson", "talisson@gmail.com");

		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(alex, tales));

		return ResponseEntity.ok().body(list);

	}
}
