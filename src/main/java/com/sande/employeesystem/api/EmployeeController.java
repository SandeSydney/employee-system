package com.sande.employeesystem.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sande.employeesystem.model.Employee;
import com.sande.employeesystem.service.EmployeeService;

/// EmployeeController serves as the API implementation of the EmployeeService
// Annotating the class as a RESTController, exposing end points for the Employees to consume
@RequestMapping("api/v1/employee")
@RestController
public class EmployeeController {

	// reference to the actual service
	private final EmployeeService employeeService;
	
	// Constructor
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	// method to add employee; return a status code or implement error handling
	@PostMapping
	public void addPerson(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	// method to view all the employees in the database
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	// method to get employee using their id
	@GetMapping(path = "{id}")
	public Employee getEmployeeById(@PathVariable("id") UUID id){
		return employeeService.getEmployeeById(id)
				.orElse(null);
	}
	
	// method to update employee's data using their id
	@PutMapping(path = "{id}")
	public void updateEmployeeById(@PathVariable("id") UUID id, @RequestBody Employee employeeToUpdate) {
		employeeService.updatePersonById(id, employeeToUpdate);
	}
	
	// method to delete employee using their id
	@DeleteMapping(path = "{id}")
	public void deleteEmployeeById(@PathVariable("id") UUID id) {
		employeeService.deletePersonById(id);
	}
}
