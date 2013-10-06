package com.gpr.mvc.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gpr.mvc.exception.BadRequestException;
import com.gpr.mvc.model.JobSeekerRegistrationForm;
import com.gpr.service.RegistrationService;

@Controller
@RequestMapping("/reg")
public class RegistrationController {
	
	
    @Autowired
	private RegistrationService registrationService;
	
	@RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody void registerJobSeeker(@Valid JobSeekerRegistrationForm form,
					 BindingResult bindingResult) throws BadRequestException {
    if (bindingResult.hasErrors()) {
	throw new BadRequestException(bindingResult);
    }
    registrationService.registerJobSeeker(form);
	}


	 @RequestMapping(value="/upload", method = RequestMethod.POST)
	    public @ResponseBody void upload(HttpServletRequest request, HttpServletResponse response) {
	 
	        //1. build an iterator
	         Enumeration<String> itr =  request.getParameterNames();
	         Object mpf = null;
	 
	         //2. get each file
	         while(itr.hasMoreElements()){
	 
	             //2.1 get next MultipartFile
	             mpf = request.getParameter((itr.nextElement())); 
	             System.out.println(mpf +" uploaded! "+mpf);
	 
	         }
	         
	         System.out.println(request);
	    }
	
}
