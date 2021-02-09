package com.cognizant.authentication.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.authentication.model.User;
import com.cognizant.authentication.repository.UserRepository;




@Service
public class AppUserDetailsService implements UserDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LOGGER.info("UserDetails -> loadUserByUsername() has Started");
			
		User user = userRepository.findByUserName(username);
		
		UserDetails appUser;
		
		if(user != null) {
			LOGGER.info("UserDetails -> loadUserByUsername() is not NULL");
			appUser = new AppUser(user);
		}
		else {
			LOGGER.info("UserDetails -> loadUserByUsername() is NULL throw EXCEPTION");
			throw new UsernameNotFoundException(username);
		}
		
		LOGGER.info("UserDetails -> loadUserByUsername() has ended");		
		return appUser;
	}

}
