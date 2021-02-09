package com.cognizant.menuitem.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.menuitem.model.MenuItem;
import com.cognizant.menuitem.repository.MenuItemRepository;


@Component
public class MenuItemServiceImpl {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemServiceImpl.class);
	
	@Autowired
	MenuItemRepository menuItemRepository;
	
	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("MenuItemServiceImpl->getMenuItemListCustomer() Started and Ended");
		return menuItemRepository.findAllByActiveTrueAndDateOfLaunchBefore(new Date());
	}
	
	public List<MenuItem> getMenuItemListAdmin() {
		LOGGER.info("MenuItemServiceImpl->getMenuItemListAdmin() Started and Ended");
		return menuItemRepository.findAll();	
	}
	
	public MenuItem getMenuItem(int id) {
		LOGGER.info("MenuItemServiceImpl->getMenuItem(id) Started and Ended");
		return menuItemRepository.findById(id).get();
	}
	
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("MenuItemServiceImpl->modifyMenuItem(menuItem) Started and Ended");
		menuItemRepository.save(menuItem);
	}
	

}
