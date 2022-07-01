package com.flightapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entity.AdminEntity;

public interface ResistrationRepository extends JpaRepository<AdminEntity, Integer>{

	public AdminEntity findByEmailId(String emailId);
	
	public AdminEntity findByEmailIdAndPassword(String emailId,String password);
}
