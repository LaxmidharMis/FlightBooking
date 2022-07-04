package com.test.repo;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entities.Person;

public interface PersonRepo extends JpaRepository<Person,Integer>{
	
	@Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM Person s WHERE s.personId = :id")
	Boolean isPersonExitsById(Integer id);

}
