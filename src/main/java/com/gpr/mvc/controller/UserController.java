package com.gpr.mvc.controller;

import com.gpr.integration.SendGrid;
import com.gpr.mvc.exception.BadRequestException;
import com.gpr.mvc.exception.RecordNotFoundException;
import com.gpr.mvc.model.AppUser;
import com.gpr.mvc.model.SignupForm;
import com.gpr.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.UUID;

/**
 * Controller for User purposes.
 */
@Controller
    @RequestMapping("/user")
    public class UserController {

    @Autowired
	private UserService userService;
    
    private static final String SMTP_AUTH_USER = System.getenv("SENDGRID_USERNAME");
    private static final String SMTP_AUTH_PWD  = System.getenv("SENDGRID_PASSWORD");


	@RequestMapping(method = RequestMethod.POST)
	    @ResponseStatus(HttpStatus.OK)
	    public @ResponseBody void createUser(@Valid SignupForm signupForm,
						 BindingResult bindingResult) throws BadRequestException {
	    if (bindingResult.hasErrors()) {
		throw new BadRequestException(bindingResult);
	    }
	    try{
	    userService.createUser(signupForm.getFirstName(),signupForm.getLastName(),signupForm.getEmail(),signupForm.getPassword(),signupForm.getAccountType());
	    }catch(org.springframework.dao.DataIntegrityViolationException exception){
	    	bindingResult.rejectValue("email", "400", "Email ["+ signupForm.getEmail() +"] is already registered!!!");
	    	throw new BadRequestException(bindingResult);
	    }
	    
	    try{
	    	SendGrid sendgrid = new SendGrid(SMTP_AUTH_USER, SMTP_AUTH_PWD);

	    	sendgrid.addTo(signupForm.getEmail());
	    	sendgrid.setFrom("admin@gpr.com");
	    	sendgrid.setSubject("Welcome Onboard");
	    	sendgrid.setText("Thanks for registering to GPR portal, lets get notified for any update.");

	    	sendgrid.send();

	    	
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}


	@RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
	    @ResponseStatus(HttpStatus.OK)
	    public @ResponseBody AppUser getUser(@PathVariable UUID uuid) throws RecordNotFoundException {
		AppUser user = userService.getUser(uuid);
	    if(user == null) {
		throw new RecordNotFoundException("Record not found for user with uuid: " + uuid);
	    }
	    return user;
	}

	@RequestMapping(value = "/{uuid}", method = RequestMethod.DELETE)
	    @ResponseStatus(HttpStatus.OK)
	    public @ResponseBody void deleteUser(@PathVariable UUID uuid) throws RecordNotFoundException {
	    // In a typical Spring/Web application, we would get uuid of the  user from session/security context
		userService.deleteUser(uuid);
	}
    }