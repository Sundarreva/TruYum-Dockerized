package com.cognizant.authentication.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authentication.exception.UserAlreadyExistException;
import com.cognizant.authentication.model.User;
import com.cognizant.authentication.service.UserService;




@RestController
@RequestMapping("/truyum")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDetailsService userDetailsManager;
	
	@Autowired
	UserService userService;

	@PostMapping("/signup")
	public void signup(@RequestBody @Valid User user) throws UserAlreadyExistException {

		LOGGER.info("UserController-> signup(user) Started");
		LOGGER.debug("user:{}",user);
		LOGGER.debug("user:{}",user.getFirstName());
		LOGGER.debug("user:{}",user.getLastName());
		LOGGER.debug("user:{}",user.getPassword());
		
		userService.signup(user);
		
		
		//inMemoryUserDetailsManager.

//		if (inMemoryUserDetailsManager.userExists(user.getUserName())) {
//
//			LOGGER.info("UserController-> signup(user) UserAlreadyExist TRUE - Exception");
//			throw new UserAlreadyExistException("User Already Exist");
//
//		} else {
//
//			LOGGER.info("UserController-> signup(user) UserAlreadyExist FALSE");
//			inMemoryUserDetailsManager
//					.createUser(org.springframework.security.core.userdetails.User.withUsername(user.getUserName())
//							.password(passwordEncoder().encode(user.getPassword())).roles("USER").build());
//
//			LOGGER.info("UserController-> signup(user) Ended");
//
//		}
	}

	public PasswordEncoder passwordEncoder() {

		LOGGER.info("Password Encoder Started and Ended");
		return new BCryptPasswordEncoder();

	}

}
