package com.example.junitexample.modal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
	
	private String userName;
	
	private String password;
	
	private String role;

}
