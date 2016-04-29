package com.my.finalproject.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.PainDAO;
import com.my.finalproject.model.PainCategory;
import com.my.finalproject.model.UserAccount;


@Controller
public class PopulatePainController {
			
	@Autowired
	PainDAO paindao;
	
	@RequestMapping(value="/pain",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<PainCategory> listPains(@RequestBody UserAccount ua){
		int id = ua.getUserid();
		return paindao.listpain(id);
	}
	
}
