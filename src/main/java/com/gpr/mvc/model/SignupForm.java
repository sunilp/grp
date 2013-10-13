package com.gpr.mvc.model;

import com.gpr.mvc.validator.Account;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Bean class used to validate input fields. Annotations validators can also applied to method parameters as well as return
 * values. Look at the following hibernate manual, section 3.1.
 *
 * @SafeHtml annotation can be used to validate against malicious code
 * http://docs.jboss.org/hibernate/validator/5.0/api/index.html?org/hibernate/validator/constraints/SafeHtml.html
 */
public class SignupForm {

    @SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT, additionalTags = "<blah>")
    @NotNull
	@Size(min = 1, max = 40, message = "Invalid format")
	private String firstName;

    @SafeHtml
	@Size(min = 1, max = 40, message = "Invalid format")
	private String lastName;

    @SafeHtml
    @Account
	private String email;
    
    @SafeHtml
    @Size(min = 1, max = 40, message = "Invalid format")
    private String password;
    
    @SafeHtml
    @Size(min = 1, max = 40, message = "Invalid format")
    private String confirmPassword;

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	// Used for Spring Bean Validation purposes
    public SignupForm() {};

    // Used for unit testing purposes
    public SignupForm(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}