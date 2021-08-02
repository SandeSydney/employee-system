package com.sande.employeesystem.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

/// Employee class is the model class for the Employee
public class Employee {
	
	// model attributes of the Employee: id, firstName, lastName, employeeNumber, email
	private final UUID id;
	private final String firstName;
	private final String lastName;
	private final int employeeNumber;
	private final String email;
	
	// class constructor with employee parameters and JSON Properties
	public Employee(
			@JsonProperty("id") UUID id,
			@JsonProperty("firstName") String firstName,
			@JsonProperty("lastName") String lastName, 
			@JsonProperty("employeeNumber") int employeeNumber, 
			@JsonProperty("email") String email ) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeNumber = employeeNumber;
		this.email = email;
	}
	
	// Employee attributes getters

	public UUID getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public String getEmail() {
		return email;
	}
	
	
}
