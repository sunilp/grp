package com.gpr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
import com.gpr.mvc.exception.RecordNotFoundException;
import com.gpr.mvc.model.AppUser;
import com.gpr.mvc.model.LoginForm;
import com.gpr.service.UserService;

@Controller
@RequestMapping("/session")
public class SessionController {
	
    @Autowired
	private UserService userService;
	
	 @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody AppUser login(@Valid LoginForm form,
					 BindingResult bindingResult,HttpServletRequest request, HttpServletResponse response) throws BadRequestException, RecordNotFoundException {
    if (bindingResult.hasErrors()) {
	throw new BadRequestException(bindingResult);
    }
    
    AppUser user =   userService.getUserByEmailAndPassword(form.getEmail(), form.getPassword());
    user.setCsrf(user.getId());
    
    HttpSession session =  request.getSession(true);
    session.setAttribute("user", user);
    
    return user;
	}


	 @RequestMapping(value="/logout",method = RequestMethod.DELETE)
	    @ResponseStatus(HttpStatus.OK)
	 public @ResponseBody void logout(HttpServletRequest request, HttpServletResponse response)  {
        
		HttpSession session =  request.getSession(false);
		if(session!=null)
		session.invalidate();
		 System.out.println("logging out");
	    
	    return ;
		}
	 
}
