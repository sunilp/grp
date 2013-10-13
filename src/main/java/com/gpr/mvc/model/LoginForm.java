package com.gpr.mvc.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;

public class LoginForm {

	 
		@SafeHtml
	    @NotNull
		private String email;
	    @NotNull
	    @SafeHtml
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
