package com.sande.employeesystem.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sande.employeesystem.dao.EmployeeDao;
import com.sande.employeesystem.model.Employee;

/// EmployeeService class provides the services for the employees to the API
@Service
public class EmployeeService {

	// creating an instance of the EmployeeDao
	private final EmployeeDao employeeDao;
	
	// injecting DAO into the actual constructor; AutoWorong into the EmployeeDao interface
	@Autowired
	public EmployeeService(@Qualifier("fakeDao") EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	// service for the method to insert a new employee
	public int addEmployee(Employee employee) {
		return employeeDao.insertEmployee(employee);
	}
	
	// service for the method to view employees in the database
	public List<Employee> getAllEmployees(){
		return employeeDao.selectAllEmployees();
	}
	
	// service for the method to get an employee using their id
	public Optional<Employee> getEmployeeById(UUID id){
		return employeeDao.selectEmployeeById(id);
	}
	
	// service for the method to update data using their id
	public int updatePersonById(UUID id, Employee newEmployee) {
		return employeeDao.updateEmployeeById(id, newEmployee);
	}
	
	// service for the method to delete employee using their id
	public int deletePersonById(UUID id) {
		return employeeDao.deleteEmployeeById(id);
	}
}
