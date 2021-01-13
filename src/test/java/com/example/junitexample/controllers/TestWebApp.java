package com.example.junitexample.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.junitexample.modal.Employee;
import com.example.junitexample.services.EmployeeService;

public class TestWebApp extends SpringBootHelloWorldTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService employeeService;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
	}

	@Test
	public void testEmployee() throws Exception {
		
		Employee emp = new Employee("1", "Altaf", "Boss", 0);
		
		when(employeeService.getEmployee("1")).thenReturn(emp);

		mockMvc.perform(get("/employee/1")).andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andExpect(jsonPath("$.name").value("Altaf")).andExpect(jsonPath("$.designation").value("Boss"))
			.andExpect(jsonPath("$.empId").value("1")).andExpect(jsonPath("$.salary").value("0.0"));
	}

}
