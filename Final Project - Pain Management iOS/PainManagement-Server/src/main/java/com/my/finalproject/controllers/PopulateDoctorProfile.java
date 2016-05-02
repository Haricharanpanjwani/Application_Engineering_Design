package com.my.finalproject.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.DoctorDAO;
import com.my.finalproject.model.DoctorProfile;
import com.my.finalproject.model.UserAccount;

@Controller
public class PopulateDoctorProfile {
	
	@Autowired
	DoctorDAO doctordao;
	
	@RequestMapping(value="/doctorlist",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<DoctorProfile> listDoctor(){
		return doctordao.getDoctors();
	}
	
	@RequestMapping(value="/doctor",method=RequestMethod.POST)
	@ResponseBody
	public DoctorProfile showDoctor(@RequestBody UserAccount ua){
		int id = ua.getUserid();
		System.out.println(id);
		return doctordao.showDoctor(id);
	}
}
