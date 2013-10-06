package com.gpr.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gpr.db.domain.JobSeeker;
import com.gpr.db.repository.JobSeekerRepository;
import com.gpr.mvc.model.JobSeekerRegistrationForm;
import com.gpr.mvc.model.SignupForm;

@Service
@Transactional
public class RegistrationService {
   
   @Autowired
   private JobSeekerRepository jobSeekerRepository;
	  
   public void registerJobSeeker(JobSeekerRegistrationForm form ){
	   JobSeeker seeker = new JobSeeker();
	   seeker.setAddress(form.getAddress());
	   seeker.setCollegeCode(form.getCollegeCode());
	   seeker.setEduBackground(form.getEduBackground());
	   seeker.setEmail(form.getEmail());
	   seeker.setFirstName(form.getFirstName());
	   seeker.setLastName(form.getLastName());
	   seeker.setMobileNum(form.getMobileNum());
	   try {
		if(form.getPhoto() != null && form.getPhoto().getBytes().length == 0){
			   seeker.setPhoto(form.getPhoto().getBytes());
		   }
		if(form.getResume() != null && form.getResume().getBytes().length == 0){
			   seeker.setResume(form.getResume().getBytes());
		   }
	      } catch (Exception e) {
	        	e.printStackTrace();
	     }
	   
	   jobSeekerRepository.save(seeker);
	   
   }

}
