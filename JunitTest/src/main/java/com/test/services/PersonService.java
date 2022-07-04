package com.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entities.Person;
import com.test.repo.PersonRepo;

@Service
public class PersonService {

	@Autowired
	private PersonRepo repo;

	public PersonService(PersonRepo repo) {
		this.repo = repo;
	}

	public List<Person> getAllPersons() {
		return this.repo.findAll();
	}

}
