package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.model.Product;
import com.sportyshoes.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	//add
	@PostMapping("/add")
	public String addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return "Product added successfully";
	}

	//all
	@GetMapping("/list")
	public List<Product> listAllProducts(){
		return productService.listAllProducts();
		
	}
	//byId
	@GetMapping("/list/{id}")
	public Product findProductById(@PathVariable long id) {
		 return productService.findProductById(id);
		
	}
}
