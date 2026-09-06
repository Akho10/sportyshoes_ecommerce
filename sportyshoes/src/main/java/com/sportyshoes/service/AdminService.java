package com.sportyshoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.Admin;
import com.sportyshoes.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	//addAdmin
//	public Admin addAmin(Admin admin) {
//		return adminRepository.save(admin);
//	}
	
	//login
	public Admin adminLogin(String username, String password){
		
		Admin admin = adminRepository.findByUsernameAndPassword(username, password);
		
		if(admin != null) {
			if(admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
				return admin;
			}
		}
		return null;
				
	}

}
