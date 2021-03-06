package com.flightapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.AdminEntity;
import com.flightapp.repository.ResistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistraionService {

	@Autowired
	private ResistrationRepository registrationRepo;

	@Override
	public AdminEntity saveAdmin(AdminEntity admin) {

		return registrationRepo.save(admin);
	}

	@Override
	public AdminEntity getUserByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return registrationRepo.findByEmailId(emailId);
	}

	@Override
	public AdminEntity getUserByEmailIdAndPassword(String emailId,String password) {
		
		return registrationRepo.findByEmailIdAndPassword(emailId,password);
	}

}
