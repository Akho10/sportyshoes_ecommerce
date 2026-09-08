package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.model.User;
import com.sportyshoes.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	public String register(@RequestBody User user) {
		 userService.register(user);
		 return "User registered sucesffully";
	}
	
	@PostMapping("/login")
	public String userLogin(String fullName, String email,@RequestBody User user) {
		userService.userLogin(fullName, email);
		return "User logged in successfully";
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String removeById(@PathVariable long id) {
		userService.removeUserById(id);
		return "User with id "+ id + "has been deleted.";
	}
	
	@GetMapping("/list")
	public List<User> getUsers(){
		return userService.getUsers();
	}
}
