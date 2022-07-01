package com.flightapp.service;

import java.util.List;
import java.util.Optional;

import com.flightapp.entity.User;

public interface UserService {

	public Integer saveUser(User user);

	public List<User> getAllUser();

	public Optional<User> getUser(Integer id);
	
	public void deleteUser(Integer id);
}
