package com.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

}
