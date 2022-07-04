package com.test.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.repo.PersonRepo;
import com.test.services.PersonService;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	@Mock
	private PersonRepo personRepo;

	private PersonService personService;

	int rollno = 1;

	@BeforeEach
	void setUp() {
		this.personService = new PersonService(this.personRepo);
	}

	@Test
	void getAllPersons() {
		personService.getAllPersons();
		verify(personRepo).findAll();
	}
}
