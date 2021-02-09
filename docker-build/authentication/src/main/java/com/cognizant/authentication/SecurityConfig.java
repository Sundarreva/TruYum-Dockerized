package com.cognizant.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.authentication.security.AppUserDetailsService;
import com.cognizant.authentication.security.JwtAuthorizationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);
	
	@Autowired
	AppUserDetailsService appUserDetailsService;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		LOGGER.info("SecurityConfigure->configure() Started");
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
		LOGGER.info("SecurityConfigure->configure() Ended");
	}

//	@Bean
//	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//		LOGGER.info("SecurityConfigure->inMemoryUserDetailsManager() Started");
//		List<UserDetails> userDetailsList = new ArrayList<UserDetails>();
//
//		userDetailsList.add(User.withUsername("user")
//						.password(passwordEncoder()
//						.encode("pwd"))
//						.roles("USER")
//						.build());
//
//		userDetailsList.add(User.withUsername("admin")
//								.password(passwordEncoder()
//								.encode("pwd"))
//						.roles("ADMIN")
//						.build());
//
//		LOGGER.info("SecurityConfigure->inMemoryUserDetailsManager() Ended");
//		return new InMemoryUserDetailsManager(userDetailsList);
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("SecurityConfigure->passwordEncoder() Started and Ended");
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		LOGGER.info("SecurityConfigure->configure(HttpSecurity) Started");
		httpSecurity.cors();
		httpSecurity.csrf().disable()
						   .httpBasic()
						   .and().authorizeRequests()
						   .antMatchers("/truyum/menu-items")
						   .anonymous().and()
						   .authorizeRequests()
						   .antMatchers("/truyum/menu-items")
						   .permitAll().and()
						   .authorizeRequests()
						   .antMatchers("/truyum/signup")
						   .anonymous()
						   .anyRequest()
						   .authenticated().and()
						   .addFilter(new JwtAuthorizationFilter(authenticationManager()));
	}
}
