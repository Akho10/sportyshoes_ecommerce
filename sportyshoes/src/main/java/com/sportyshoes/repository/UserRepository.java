package com.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sportyshoes.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("Select u From User u Where u.fullName=:fullName AND u.email=:email")
	public User findByFullNameAndEmail(String fullName, String email);
}
