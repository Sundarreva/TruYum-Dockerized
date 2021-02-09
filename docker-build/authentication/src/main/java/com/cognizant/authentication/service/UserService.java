package com.cognizant.authentication.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.authentication.exception.UserAlreadyExistException;
import com.cognizant.authentication.model.Role;
import com.cognizant.authentication.model.User;
import com.cognizant.authentication.repository.UserRepository;



@Service
public class UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Transactional
	public User getByUsername(String name) {
		LOGGER.info("User->getByUsername() has started and ended");
		return userRepository.findByUserName(name);
	}
	
	@Transactional
	public void signup(User user) throws UserAlreadyExistException {
		
		LOGGER.info("User->signUp(user) has started");		
		if(userRepository.findByUserName(user.getUserName()) == null) {
			LOGGER.info("User->signUp USER is NOT EXIST");
			LOGGER.info("User->signUp() USER is CREATING");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			
			Set<Role> roleList = new HashSet();
			Role role = new Role();
			
			role.setId(2);
			role.setName("USER");
			roleList.add(role);
			user.setUserRoleList(roleList);
			
			userRepository.save(user);
		}
		else {
			LOGGER.info("User->signUp() USER EXIST THROWING EXCEPTION");
			throw new UserAlreadyExistException("User Already Exist");
		}
	}

}
