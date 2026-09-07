package com.sportyshoes.service;

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
	
	
	
	
	
	//deleteById
	public void removeUserById(long id) {
		userRepository.deleteById(id);
	}
	
}
