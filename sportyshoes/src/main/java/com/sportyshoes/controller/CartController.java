package com.sportyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.model.Cart;
import com.sportyshoes.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;
	
	@PostMapping("add/{userId}/{productId}/{quantity}")
	public String addToCart(@PathVariable long productId,@PathVariable long userId, @PathVariable int quantity) throws Exception{
		cartService.addToCart(productId, userId, quantity);
		return "Product added to cart";
	}
	
	@GetMapping("/list/{userId}")
	public Cart findCartByUserId(@PathVariable long userId) {
		return cartService.findCartByUserId(userId);
	}
}
