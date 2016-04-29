package com.my.finalproject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.UserLoginDAO;
import com.my.finalproject.model.UserAccount;

@Controller
public class UserLoginController {
	
	@Autowired
	UserLoginDAO userlogindao;
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	//@RequestParam("username")String username,@RequestParam("password") String password
	//List<UserAccount>
	public UserAccount LoginCheck(@RequestBody UserAccount ua){
		String username = ua.getUsername();
		String password = ua.getUserpassword();
		System.out.println(username);
		UserAccount useraccount = (UserAccount)userlogindao.auth(username, password);
		if( useraccount!=null){
			return useraccount;
		}else{
			return null;
		}
	}
	

}
