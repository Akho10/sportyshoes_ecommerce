package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.model.Order;
import com.sportyshoes.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("{userId}")
	public String placeOrder(@PathVariable long userId) {
		orderService.placeOrder(userId);
		return "Order succesfully placed";
	}
	
	@GetMapping("category/{orderId}")
	public List<String> getCategory(@PathVariable long orderId) {
		return orderService.getCategory(orderId);
	}
}
