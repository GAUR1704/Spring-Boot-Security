package com.prowings.SpringBootSecurity.service;

import java.util.List;

import com.prowings.SpringBootSecurity.model.User;

public interface UserService {
	
	public List<User> getAllUser();
	
	public User getUser(String userName);
	
	public User addUser(User user);

}
