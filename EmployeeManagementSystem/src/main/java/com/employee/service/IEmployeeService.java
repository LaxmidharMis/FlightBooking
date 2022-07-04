package com.employee.service;

import java.util.List;
import java.util.Optional;

import com.employee.entity.EmployeeEntity;

public interface IEmployeeService {

	public Integer saveEmployee(EmployeeEntity employee);

	public List<EmployeeEntity> getAllEmployees();

	public Optional<EmployeeEntity> getEmployee(Integer id);

	public void deletEmployee(Integer id);

	public Integer updateEmployee(EmployeeEntity employee, Integer id);

}
