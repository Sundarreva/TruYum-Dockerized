package com.cognizant.menuitem.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.menuitem.model.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
	
	public List<MenuItem> findAllByActiveTrueAndDateOfLaunchBefore(Date date);
	
}
