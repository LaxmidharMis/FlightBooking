 package com.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.entities.Person;
import com.demo.repo.PersonRepo;

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
