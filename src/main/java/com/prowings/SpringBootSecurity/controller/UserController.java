package com.prowings.SpringBootSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.SpringBootSecurity.model.User;
import com.prowings.SpringBootSecurity.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/users")
	public List<User> getAllUser() {

		return this.userService.getAllUser();

	}

	@GetMapping("/user/{userName}")
	public User getUser(@PathVariable String userName) {

		return this.userService.getUser(userName);
	}

	@PostMapping("/users")
	public User addUser(@RequestBody User user) {

		return this.userService.addUser(user);
	}

}
