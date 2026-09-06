package com.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
