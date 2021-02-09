package com.cognizant.menuitem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.menuitem.model.MenuItem;
import com.cognizant.menuitem.service.MenuItemServiceImpl;



@RestController
@RequestMapping("/truyum")
public class MenuItemController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@Autowired
	MenuItemServiceImpl menuItemService;

//	@Autowired
//	InMemoryUserDetailsManager inMemoryUserDetailsManager;
	
	@Autowired
	UserDetailsService UserDetailsService;

	@GetMapping("/menu-items")
	public List<MenuItem> getAllMenuItems() {
		
		LOGGER.info("MenuItemController->getAllMenuItems() Started");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		
		if (user.equals("anonymousUser")) {
			
			LOGGER.info("MenuItemControlller->getAllMenuItems() anonymousUser ");
			LOGGER.info("MenuItemControlller->getAllMenuItems() Ended");
			return menuItemService.getMenuItemListCustomer();
			
		} else {
			
			LOGGER.info("MenuItemControlller->getAllMenuItems() admin or customer");
			UserDetails userEntity = UserDetailsService.loadUserByUsername(user);
			String role = userEntity.getAuthorities().toArray()[0].toString();
			
			if (role.equals("ADMIN")) {
				
				LOGGER.info("MenuItemControlller-> admin");
				LOGGER.info("MenuItemControlller->getAllMenuItems() Ended");
				return menuItemService.getMenuItemListAdmin();
				
			} else {
				
				LOGGER.info("MenuItemControlller-> customer");
				LOGGER.info("MenuItemControlller->getAllMenuItems() Ended");
				return menuItemService.getMenuItemListCustomer();
				
			}
		}
	}

	@GetMapping("/menu-items/{id}")
	public MenuItem getMenuItem(@PathVariable int id) {
		
		LOGGER.info("MenuItemControlller->getMenuItem() Started and Ended");
		return menuItemService.getMenuItem(id);
		
	}

	@PutMapping("/menu-items")
	public void modifyMenuItem(@RequestBody MenuItem menuItem) {
		
		LOGGER.info("MenuItemControlller->getMenuItem() Started and Ended");
		menuItemService.modifyMenuItem(menuItem);
		
	}

}
