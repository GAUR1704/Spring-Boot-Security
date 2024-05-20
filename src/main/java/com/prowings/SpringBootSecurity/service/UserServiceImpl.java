package com.prowings.SpringBootSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.SpringBootSecurity.model.User;
import com.prowings.SpringBootSecurity.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    
    @Override
    public User getUser(String userName) {
        Optional<User> optionalUser = userRepository.findByUserName(userName);
        return optionalUser.orElse(null);
    }
    
    @Override
    public User addUser(User user) {
        // Assuming no duplicate usernames allowed
        if (getUser(user.getUserName()) == null) {
            return userRepository.save(user);
        }
        return null; // User with the same username already exists
    }
    
    
}
