package com.example.junitexample;

public class Authorization {

	private Authentication authentication;

	public Authorization(Authentication authentication) {
		// TODO Auto-generated constructor stub
		this.authentication = authentication;
	}

	public boolean hasAccess(String page) {
		// TODO Auto-generated method stub
		
		if(authentication != null && authentication.getRole() != null) {
			if(page.equals("welcome")) {
				return true;
			} else if(page.equals("admin")) {
				if(authentication.getRole().equals("Admin")) {
					return true;
				}
			}
		}

		return false;
	}
	
	

}
