package com.gpr.mvc.model;

/**
 * Model object for Prism users
 */
public class AppUser {

	private String id;
	
	private String csrf;

	private String firstName;

    private String lastName;

    private String email;

    public String getCsrf() {
		return csrf;
	}

	public void setCsrf(String csrf) {
		this.csrf = csrf;
	}

	public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}