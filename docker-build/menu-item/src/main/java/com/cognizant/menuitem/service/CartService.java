package com.cognizant.menuitem.service;

import java.util.Set;

import com.cognizant.menuitem.exception.CartEmptyException;
import com.cognizant.menuitem.model.MenuItem;


public interface CartService {
	
	public Set<MenuItem> getAllCartItems(String user)throws CartEmptyException;
	
	public void addCartItem(String user, long menuItemId);
	
	public Set<MenuItem> removeCartItem(String user, long menuItemId);

}
