package com.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sportyshoes.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

	@Query("Select a From Admin a Where a.username=:username AND a.password=:password")
	public Admin findByUsernameAndPassword(String username, String password);		
}
