package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.EmployeeEntity;
import com.employee.service.IEmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	IEmployeeService employeeService;
	
	@PostMapping("/saveEmployee")
	public Integer createEmployee(@RequestBody EmployeeEntity employee) {
		Integer id = employeeService.saveEmployee(employee);
		System.out.println("Employee saved id..." + id);
		return id;
		
	}
	
	@GetMapping("/allEmployees")
	public List<EmployeeEntity> getAllEmployee() {

		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employee/{id}")
	public Optional<EmployeeEntity> getStudent(@PathVariable Integer id) {
		Optional<EmployeeEntity> student = employeeService.getEmployee(id);
		return student;
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<EmployeeEntity> deleteStudent(@PathVariable Integer id) {
		System.out.println(id);
		ResponseEntity<EmployeeEntity> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			employeeService.deletEmployee(id);;
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<EmployeeEntity>(HttpStatus.NOT_FOUND);
		}

		return responseEntity;
	}

	
	@PutMapping("/employee/{id}")
	public ResponseEntity<EmployeeEntity> updateStudent(@PathVariable Integer id, @RequestBody EmployeeEntity student) {
		System.out.println(id);
		ResponseEntity<EmployeeEntity> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			employeeService.updateEmployee(student, id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<EmployeeEntity>(HttpStatus.NOT_FOUND);
		}

		return responseEntity;
	}


	
}
