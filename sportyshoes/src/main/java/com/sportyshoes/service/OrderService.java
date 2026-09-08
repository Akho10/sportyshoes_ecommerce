package com.sportyshoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.Cart;
import com.sportyshoes.model.Order;
import com.sportyshoes.model.Product;
import com.sportyshoes.model.User;
import com.sportyshoes.model.Payment;
import com.sportyshoes.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PaymentService paymentService;
	
	//placeOrder
//	@Transactional
//	public Order placeOrder(long userId, long productId,double amount){
//		//find user
//		User user = userService.findUserById(userId);
//		//check user cart
//		Cart cart= cartService.findCartByUserId(userId);
//		if (cart == null) {
//			throw new RuntimeException("Cart not found");
//		}
//		//get cart products
//		List<Product> products = cart.getProducts();
//		
//		if(products.isEmpty()) {
//			throw new RuntimeException("Items not found");
//		}
//		
//		//reduce quantity
//		for(Product product: products) {
//			productService.reduceQuantity(productId);
//		}
//		//get amount from cart and create payment
//		amount = cart.getTotalAmount();
//		
//		Payment payment = paymentService.processPayment(amount);
//		
//		
//		//create order
//		Order order = new Order();
//		order.setUser(user);
//		order.setProducts(products);
//		order.setOrderAmount(amount);
//		order.setPayment(payment);
//		
//		//process payment
//		//save order
//		return orderRepository.save(order);
//		
//	}
	
	@Transactional
	public Order placeOrder(long userId){
		//find user
		User user = userService.findUserById(userId);
		//check user cart
		Cart cart= cartService.findCartByUserId(userId);
		if (cart == null) {
			throw new RuntimeException("Cart not found");
		}
		//get cart products
		List<Product> products = cart.getProducts();
		
		if(products.isEmpty()) {
			throw new RuntimeException("Items not found");
		}
		
		//reduce quantity
		for(Product product: products) {
			productService.reduceQuantity(product.getId());
		}
		//get amount from cart and create payment
		double amount = cart.getTotalAmount();
		
		Payment payment = paymentService.processPayment(amount);
		
		
		//create order
		Order order = new Order();
		order.setUser(user);
//		order.getProducts().add(product);
		order.getProducts().addAll(products);
		order.setOrderAmount(amount);
		order.setPayment(payment);
		
		//process payment
		//save order
		return orderRepository.save(order);
		
	}
	
	//getCategory
	public List<String> getCategory(long orderId) {
		Order order = orderRepository.findById(orderId).orElseThrow();
		
		if(order == null) {
			throw new RuntimeException("Order not found");
		}
		
		List<String> categories = new ArrayList<>();
		
		for(Product product: order.getProducts()) {
			categories.add(product.getCategory());
			
		}
		
		return categories;
		
	}
}
