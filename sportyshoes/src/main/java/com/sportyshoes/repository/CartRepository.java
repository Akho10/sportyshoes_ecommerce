package com.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sportyshoes.model.Cart;
import com.sportyshoes.model.Product;

public interface CartRepository extends JpaRepository<Cart, Long>{

	public Cart findCartByUserId(long id);
	//find all items in cart
	
}
