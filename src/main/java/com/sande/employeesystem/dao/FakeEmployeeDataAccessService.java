package com.sande.employeesystem.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.sande.employeesystem.model.Employee;

/// FakeEmployeeDataAccessService implements the EmployeeDao
// initiate class as a bean
@Repository("fakeDao")
public class FakeEmployeeDataAccessService implements EmployeeDao{
	
	// The list of employees in the database
	private static List<Employee> DB = new ArrayList<Employee>();

	// method to insert Employee into the database, returning 1 for success
	@Override
	public int insertEmployee(UUID id, Employee employee) {
		DB.add(
				new Employee(
						id, 
						employee.getFirstName(), 
						employee.getLastName(), 
						employee.getEmployeeNumber(), 
						employee.getEmail()
						)
				);
		return 1;
	}

	// method to select all the employees from the database
	@Override
	public List<Employee> selectAllEmployees() {
		return DB;
	}

	// method to select a single employee using their id
	@Override
	public Optional<Employee> selectEmployeeById(UUID id) {
		// search DB for the availability of the employee id by streaming the DB
		return DB.stream()
				.filter(employee -> employee.getId().equals(id))
				.findFirst();
	}

	// method to update employee data, finding them by id
	@Override
	public int updateEmployeeById(UUID id, Employee update) {
		/**
		 * select employee
		 * map employee to something 
		 * if index>=0, employee has been found in the DB
		 * set contents to those passed by employee 
		 */
		return selectEmployeeById(id)
				.map(employee -> {
					int indexOfEmployeeToUpdate = DB.indexOf(employee);
					if(indexOfEmployeeToUpdate >= 0) {
						DB.set(
								indexOfEmployeeToUpdate, 
								new Employee(id, update.getFirstName(), update.getLastName(), 
										update.getEmployeeNumber(), update.getEmail()));
					}
					 return 0;
				})
				.orElse(0);
	}

	// method to delete employee data by using the id
	@Override
	public int deleteEmployeeById(UUID id) {
		// find employee.id. If present, delete the data. If not, return 0
		Optional<Employee> employeeMaybe = selectEmployeeById(id);
		if(employeeMaybe.isEmpty()) {
			return 0;
		}
		DB.remove(employeeMaybe.get());
		return 1;
	}

}
