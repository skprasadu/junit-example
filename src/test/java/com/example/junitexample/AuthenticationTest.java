package com.example.junitexample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.junitexample.modal.User;

public class AuthenticationTest {
	
	@BeforeEach
	public void setup() {
		Authentication.userList.add(User.builder().userName("Altaf").password("pass").role("Admin").build());
		Authentication.userList.add(User.builder().userName("Krishna").password("pass").role("User").build());
		Authentication.userList.add(User.builder().userName("Nick").password("pass").role("Developer").build());
		Authentication.userList.add(User.builder().userName("Niel").password("pass").role("Tester").build());
	}
	
	@Test
	public void testLogin() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Altaf", "pass"));
	}
	
	@Test
	public void testWrongUserLogin() {
		Authentication authentication = new Authentication();
		
		assertEquals(false, authentication.login("Jake", "pass"));
	}

	@Test
	public void testUserAssert() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Altaf", "pass"));
		
		assertEquals("Altaf", authentication.getUserName());
	}
	
	@Test
	public void testRoleAssert() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Altaf", "pass"));
		
		assertEquals("Admin", authentication.getRole());
	}

	@Test
	public void testLogout() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Altaf", "pass"));
		
		authentication.logout();
		
		assertEquals(null, authentication.getRole());
	}

}
