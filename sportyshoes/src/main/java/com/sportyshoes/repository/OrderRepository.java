package com.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
