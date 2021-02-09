package com.cognizant.menuitem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.menuitem.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUserName(String name);
}
