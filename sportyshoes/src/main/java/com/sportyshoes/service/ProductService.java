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
	
	@Autowired
	AdminService adminService;
	
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
	
	//updateProduct
	public Product updateProduct(long id, Product product) {
		Product existingProduct = findProductById(id);
		
		existingProduct.setName(product.getName());
		existingProduct.setDepartment(product.getDepartment());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		
		return productRepository.save(existingProduct);
	}
	
	//reduceQuantity
	public void reduceQuantity(long productId) {
		Product product = findProductById(productId);
		
		if(product.getQuantity() <= 0 ) {
			throw new RuntimeException("Product is out of stock");
		}
		
		product.setQuantity(product.getQuantity() - 1);
		productRepository.save(product);
	}
}
