package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeRepository iEmployeeRepo;

	@Override
	public Integer saveEmployee(EmployeeEntity employee) {
		EmployeeEntity saveEmployee = iEmployeeRepo.save(employee);
		return saveEmployee.getEmployeeId();
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		return iEmployeeRepo.findAll();
	}

	@Override
	public Optional<EmployeeEntity> getEmployee(Integer id) {
		return iEmployeeRepo.findById(id);
	}

	@Override
	public void deletEmployee(Integer id) {
		iEmployeeRepo.deleteById(id);

	}

	@Override
	public Integer updateEmployee(EmployeeEntity employee, Integer id) {
		EmployeeEntity existingEmployee = iEmployeeRepo.findById(id).orElseThrow();
		existingEmployee.setEmployeeName(employee.getEmployeeName());
		existingEmployee.setEmployeeDesignation(employee.getEmployeeDesignation());
		existingEmployee.setEmployeeAge(employee.getEmployeeAge());
		existingEmployee.setEmployeeEmail(employee.getEmployeeEmail());
		existingEmployee.setEmployeeGender(employee.getEmployeeGender());
		iEmployeeRepo.save(existingEmployee);
		return existingEmployee.getEmployeeId();
	}

}
