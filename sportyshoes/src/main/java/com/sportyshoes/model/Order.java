package com.sportyshoes.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
//	private int orderNum;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	private double orderAmount;
	
	@ManyToMany
	@JoinTable(
			name="order_items",
			joinColumns= @JoinColumn(name="order_id"),
			inverseJoinColumns = @JoinColumn(name="product_id")
			)
	private List<Product> products = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="payment")
	private Payment payment;
	
	public Order() {}

	public long getId() {
		return id;
	}

//	public int getOrderNum() {
//		return orderNum;
//	}
//
//	public void setOrderNum(int orderNum) {
//		this.orderNum = orderNum;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	
	
}
