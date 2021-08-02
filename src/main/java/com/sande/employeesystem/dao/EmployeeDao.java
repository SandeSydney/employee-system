package com.sande.employeesystem.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sande.employeesystem.model.Employee;

/// DAO that implements the Employee model
public interface EmployeeDao {
	
	// method to insert an employee into the database
	int insertEmployee(UUID id, Employee employee);
	
	// default method to insert an employee, creating the employees id
	default int insertEmployee(Employee employee) {
		UUID id = UUID.randomUUID();
		return insertEmployee(id, employee);
	}
	
	// method to read all the employees in the database
	List<Employee> selectAllEmployees();
	
	// method to select an individual employee using their id
	Optional<Employee> selectEmployeeById(UUID id);
	
	// method to update Employee data, using their id
	int updateEmployeeById(UUID id, Employee employee);
	
	// method to delete Employee data using their id
	int deleteEmployeeById(UUID id);	
}
