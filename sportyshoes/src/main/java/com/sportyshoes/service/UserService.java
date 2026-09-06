package com.sportyshoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.User;
import com.sportyshoes.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	//add
	public User register(User user) {
		return userRepository.save(user);
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
