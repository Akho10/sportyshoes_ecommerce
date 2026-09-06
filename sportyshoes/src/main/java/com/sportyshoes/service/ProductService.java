package com.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.Product;
import com.sportyshoes.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	//add
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	//listAll
	public List<Product> listAllProducts(){
		return productRepository.findAll();
	}
	
	//listById
	public Product findProductById(long id){
		return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
	}
	
}
