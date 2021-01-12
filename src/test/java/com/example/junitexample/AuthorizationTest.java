package com.example.junitexample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.junitexample.modal.User;

public class AuthorizationTest {
	
	@BeforeEach
	public void setup() {
		Authentication.userList.add(User.builder().userName("Altaf").password("pass").role("Admin").build());
		Authentication.userList.add(User.builder().userName("Krishna").password("pass").role("User").build());
		Authentication.userList.add(User.builder().userName("Nick").password("pass").role("Developer").build());
		Authentication.userList.add(User.builder().userName("Niel").password("pass").role("Tester").build());
	}
	
	@Test
	public void testWelcomePageAccess() {
		//Login using Authenticate
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Altaf", "pass"));

		//Create Authorization object
		Authorization authorization = new Authorization(authentication);
		
		//check it has access to welcome page and assert
		assertEquals(true, authorization.hasAccess("welcome"));
	}
	
	@Test
	public void testAdminPageAccess() {
		//Login using Authenticate
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Altaf", "pass"));

		//Create Authorization object
		Authorization authorization = new Authorization(authentication);
		
		//check it has access to welcome page and assert
		assertEquals(true, authorization.hasAccess("admin"));

	}
	
	@Test
	public void testAdminPageNotAccessable() {
		//Login using Authenticate
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Krishna", "pass"));

		//Create Authorization object
		Authorization authorization = new Authorization(authentication);
		
		//check it has access to welcome page and assert
		assertEquals(false, authorization.hasAccess("admin"));

	}


	@Test
	public void testWelcomePageAccessWithoutLogin() {
		//Login using Authenticate
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Altaf", "pass"));
		
		authentication.logout();

		//Create Authorization object
		Authorization authorization = new Authorization(authentication);
		
		//check it has access to welcome page and assert
		assertEquals(false, authorization.hasAccess("admin"));

		
	}
}
