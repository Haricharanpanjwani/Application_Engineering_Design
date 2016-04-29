package com.my.finalproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.PatientDetailDAO;
import com.my.finalproject.model.PatientProfile;
import com.my.finalproject.model.UserAccount;

@Controller
public class PopulatePatientProfile {
	
	@Autowired
	PatientDetailDAO patientdao;
	
	
	@RequestMapping(value="/patientproflie",method=RequestMethod.POST)
	@ResponseBody
	public PatientProfile showProfile(@RequestBody UserAccount ua){
		int id = ua.getUserid();
		return patientdao.getProfile(id);
		
	}
	
}
