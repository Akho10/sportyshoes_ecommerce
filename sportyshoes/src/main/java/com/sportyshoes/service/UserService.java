package com.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.Cart;
import com.sportyshoes.model.User;
import com.sportyshoes.repository.CartRepository;
import com.sportyshoes.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	//add
	public User register(User user) {
		
		 user =  userRepository.save(user);
		Cart cart = new Cart();
		cart.setUser(user);
		
		cartRepository.save(cart);
		return user;
		
	}
	
	//list
	public List<User> getUsers(){
		
		return userRepository.findAll();
	}
	//login
	public User userLogin(String fullName, String email) {
		User user = userRepository.findByFullNameAndEmail(fullName, email);
		
		if(user != null) {
			if(user.getFullName().equals(fullName) && user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}
	
	
	//findById
	public User findUserById(long id) {
		return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
	}
	
	
	//deleteById
	public void removeUserById(long id) {
		userRepository.deleteById(id);
	}
	
}
