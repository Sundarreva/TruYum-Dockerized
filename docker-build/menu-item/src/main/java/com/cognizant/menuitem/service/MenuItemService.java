package com.cognizant.menuitem.service;

import java.util.List;

import com.cognizant.menuitem.model.MenuItem;

public interface MenuItemService {
	
	public List<MenuItem> getMenuItemListCustomer();
	
	public List<MenuItem> getMenuItemListAdmin();
	
	public MenuItem getMenuItem(int id);
	
	public void modifyMenuItem(MenuItem menuItem);

}
