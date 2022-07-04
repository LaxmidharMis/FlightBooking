package com.test.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.entities.Person;

@SpringBootTest
public class PersonRepoTest {
	
	@Autowired
	private PersonRepo repo;
	
	@Test
	void isPersonExistById() {
		Person person = new Person(123, "Ravi", "Bangalore");
		repo.save(person);
		Boolean actualResult = repo.isPersonExitsById(123);
		assertThat(actualResult).isTrue();
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("Tearing down....");
		repo.deleteAll();
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("setting up...");
	}
	

}
