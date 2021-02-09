package com.cognizant.menuitem.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.menuitem.exception.CartEmptyException;
import com.cognizant.menuitem.model.MenuItem;
import com.cognizant.menuitem.model.User;
import com.cognizant.menuitem.repository.MenuItemRepository;
import com.cognizant.menuitem.repository.UserRepository;


@Component
public class CartServiceImpl implements CartService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);
	
	@Autowired
	UserRepository asCart;
	
	@Autowired
	MenuItemRepository menuItemRepository; 
	
	public Set<MenuItem> getAllCartItems(String userName) throws CartEmptyException {
		
		LOGGER.info("CartServiceImpl->getAllCartItems(user) Started and Ended");
		User userDetails = asCart.findByUserName(userName);
		return userDetails.getMenuItemList();
		
	}
	
	public void addCartItem(String userName, long menuItemId) {
		
		LOGGER.info("CartServiceImpl->addCartItem(user,menuid) Started and Ended");
		User user = asCart.findByUserName(userName);
		Set<MenuItem> menuItemList = user.getMenuItemList();
		MenuItem menu = menuItemRepository.findById((int) menuItemId).get();
		
		menuItemList.add(menu);
		user.setMenuItemList(menuItemList);
		
		asCart.save(user);
		
	}
	
	public Set<MenuItem> removeCartItem(String userName, long menuItemId) {
		
		LOGGER.info("CartServiceImpl->removeCartItem(user,menuid) Started and Ended");
		
		User user = asCart.findByUserName(userName);
		Set<MenuItem> menuItemList = user.getMenuItemList();
		MenuItem menu = menuItemRepository.findById((int) menuItemId).get();
		
		menuItemList.remove(menu);
		asCart.save(user);
		
		return user.getMenuItemList();
	}
	
}
