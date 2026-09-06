package com.sportyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.model.Admin;
import com.sportyshoes.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
//	@PostMapping("/add")
//	public String addAdmin(@RequestBody Admin admin) {
//		adminService.addAmin(admin);
//		return "Admin added successfully";
//	}
	
	@PostMapping("/login")
	public String login(String username, String password, @RequestBody Admin admin) {
		adminService.adminLogin(username, password);
		return "Admin found";
	}
	
}
