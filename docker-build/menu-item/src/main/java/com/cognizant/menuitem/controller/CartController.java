package com.cognizant.menuitem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.menuitem.exception.CartEmptyException;
import com.cognizant.menuitem.model.MenuItem;
import com.cognizant.menuitem.service.CartServiceImpl;


@RestController
@RequestMapping("/truyum")
public class CartController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@Autowired
	CartServiceImpl cartService;

	List<MenuItem> cartItems = new ArrayList<MenuItem>();

	@GetMapping("cart-items/{user}")
	public Set<MenuItem> getAllCartItems(@PathVariable String user) throws CartEmptyException {
		
		LOGGER.info("CartController->getAllCartItems() Started and Ended");
		return cartService.getAllCartItems(user);
		
	}

	@PostMapping("cart-items/{user}/{menuItemId}")
	public void addCartItem(@PathVariable String user, @PathVariable int menuItemId) {
		
		LOGGER.info("CartController->AddCartItems() Started and Ended");
		cartService.addCartItem(user, menuItemId);
		
	}

	@DeleteMapping("cart-items/{user}/{menuItemId}")
	public Set<MenuItem> removeCartItem(@PathVariable String user, @PathVariable int menuItemId) {
		
		LOGGER.info("CartController->removeCartItems() Started and Ended");
		return cartService.removeCartItem(user, menuItemId);
		
	}

}
