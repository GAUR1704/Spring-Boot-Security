package com.prowings.SpringBootSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prowings.SpringBootSecurity.model.CustomUserDetail;
import com.prowings.SpringBootSecurity.model.User;
import com.prowings.SpringBootSecurity.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userRepository.getById(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("No USER");
		}
		
		
		return new CustomUserDetail(user);
	}

}
