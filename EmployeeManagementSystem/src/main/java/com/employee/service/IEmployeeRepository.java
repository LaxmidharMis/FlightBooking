package com.employee.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.EmployeeEntity;

public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

}
