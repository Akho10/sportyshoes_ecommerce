package com.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.Cart;
import com.sportyshoes.model.Product;
import com.sportyshoes.repository.CartRepository;

import jakarta.transaction.Transactional;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductService productService;
	
	//getCartByUser
	@Transactional
	public Cart addToCart(long productId,long userId, int quantity) throws Exception {
		//find user cart
		 Cart cart = cartRepository.findCartByUserId(userId);
		 
		 if(cart == null) {
			 throw new Exception("Cart is empty");
		 }
		 //find product
		Product product = productService.findProductById(productId);
		 //quantity
		if(quantity <= 0 ) {
			throw new Exception("Quantity must be greater than 0");
		}
		if(quantity > product.getQuantity()) {
			
//		product.setQuantity(product.getQuantity());
			throw new Exception("Not enough stock");
		
		}
		//add product to cart
		cart.getProducts().add(product);
		//total is prod price * quantity
		cart.setTotalAmount(cart.getTotalAmount() + (product.getPrice() * quantity));
		
		return cartRepository.save(cart);
	
		 
	}
	//getCartByUser
	public Cart findCartByUserId(long userId) {
		return cartRepository.findCartByUserId(userId);
	}
	//updateQuanitity
	//remove
	
}
