package com.personalblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalblog.dtos.UserDTO;
import com.personalblog.entities.User;
import com.personalblog.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) { 
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDTO));
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable long userId) {
		return ResponseEntity.ok().body(userService.getUserById(userId));
	}

}
