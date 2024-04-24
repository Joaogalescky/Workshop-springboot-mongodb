package com.joaogalescky.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaogalescky.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	// @RequestMapping(method = RequestMethod.GET) ou
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "Maria Silva", "maria@gmail.com");
		User matheus = new User("2", "Matheus Santos", "matheus@ymail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, matheus));
		return ResponseEntity.ok().body(list);
	}
}
