package com.demo.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entities.Person;

@SpringBootTest
public class PersonRepoTest {

	@Autowired
	private PersonRepo personRepo;
	@Test
	void isPersonExitsById() {
		Person person = new Person(123, "Raghav", "Delhi");
		personRepo.save(person);
		Boolean actualResult = personRepo.isPersonExistsById(123);
		assertThat(actualResult).isTrue();
	}
	@AfterEach
	void tearDown() {
		System.out.println("tearing down ");
		personRepo.deleteAll();
	}
	@BeforeEach
	void setUp() {
		System.out.println("setting up");
	}

}
