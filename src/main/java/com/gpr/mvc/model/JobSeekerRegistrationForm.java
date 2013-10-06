package com.gpr.mvc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.web.multipart.MultipartFile;

import com.gpr.mvc.validator.Account;

public class JobSeekerRegistrationForm {

	    @SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT, additionalTags = "<blah>")
	    @NotNull
		@Size(min = 1, max = 40, message = "Invalid format")
		private String firstName;

	    @SafeHtml
		@Size(min = 1, max = 40, message = "Invalid format")
		private String lastName;

	    @SafeHtml
		private String email;
	    
	    private MultipartFile photo;
	    private MultipartFile resume;
	    
	    @SafeHtml
	    @Size(min = 0, max = 10, message = "Invalid format")
	    private String collegeCode;
	    @SafeHtml
	    @Size(min = 0, max = 1450, message = "Invalid format")
	    private String eduBackground;
	    @SafeHtml
	    @Size(min = 0, max = 10, message = "Invalid format")
	    private String mobileNum;
	    @SafeHtml
	    @Size(min = 0, max = 1450, message = "Invalid format")
	    private String address;
	    
	    

	    // Used for Spring Bean Validation purposes
	    public JobSeekerRegistrationForm() {};

	    // Used for unit testing purposes
	    public JobSeekerRegistrationForm(String firstName, String lastName, String email) {
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

		public MultipartFile getPhoto() {
			return photo;
		}

		public void setPhoto(MultipartFile photo) {
			this.photo = photo;
		}

		public MultipartFile getResume() {
			return resume;
		}

		public void setResume(MultipartFile resume) {
			this.resume = resume;
		}

		public String getCollegeCode() {
			return collegeCode;
		}

		public void setCollegeCode(String collegeCode) {
			this.collegeCode = collegeCode;
		}

		public String getEduBackground() {
			return eduBackground;
		}

		public void setEduBackground(String eduBackground) {
			this.eduBackground = eduBackground;
		}

		public String getMobileNum() {
			return mobileNum;
		}

		public void setMobileNum(String mobileNum) {
			this.mobileNum = mobileNum;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
}
