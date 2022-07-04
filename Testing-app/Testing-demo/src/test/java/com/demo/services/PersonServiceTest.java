package com.demo.services;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.demo.repo.PersonRepo;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	
	@Mock
	private PersonRepo personRepo;
	
	private PersonService personSerivce;
	
	int rollno = 1;
	
	@BeforeEach
	void setup() {
		this.personSerivce = new PersonService(this.personRepo);
	}
	
	@Test
	void getAllPersons() {
		personSerivce.getAllPersons();
		verify(personRepo).findAll();
	}

}
