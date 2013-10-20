package com.gpr.mvc.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.SafeHtml;

public class LoginForm {

	 
		@SafeHtml
		 @Size(min = 1, max = 40, message = "Invalid Email")
		private String email;
	    @SafeHtml
	    @Size(min = 1, max = 40, message = "Invalid Password")
	    private String password;
	    
	    public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
}
