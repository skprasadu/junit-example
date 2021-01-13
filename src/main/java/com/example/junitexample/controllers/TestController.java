package com.example.junitexample.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.junitexample.modal.Employee;
import com.example.junitexample.services.EmployeeService;


@RestController
public class TestController {
	
	private EmployeeService employeeService;
	
	
	public TestController(EmployeeService employeeService) {
		this.employeeService =  employeeService;
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Employee firstPage(@PathVariable String id) {
		
		return employeeService.getEmployee(id);
	}

}
