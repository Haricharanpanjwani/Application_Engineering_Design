package com.my.finalproject.webControllers;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.InsertDAO;
import com.my.finalproject.DAO.UserLoginDAO;
import com.my.finalproject.model.PatientProfile;
import com.my.finalproject.model.UserAccount;
import com.my.finalproject.webModel.WebUserAccount;

@Controller
public class AccountsController {

	@Autowired
	UserLoginDAO userlogindao;
	@Autowired
	InsertDAO insertdao;
	
	@RequestMapping(value="/getallaccounts",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<UserAccount> listAllAccounts(){
		
		return userlogindao.populateAccounts();
	
	}
	
	@RequestMapping(value="/editaccounts",method=RequestMethod.POST)
	@ResponseBody
	public String eidtThisAccounts(@RequestBody WebUserAccount account){
		userlogindao.editAccount(account);
		return "success";
	}
	
	@RequestMapping(value="/deleteaccounts",method=RequestMethod.POST)
	@ResponseBody
	public String deleteThisAccounts(@RequestBody UserAccount user){
		System.out.println(user.getUserid());
		userlogindao.deleteUser(user);
		return "success";
	}
	
	@RequestMapping(value="/addaccounts",method=RequestMethod.POST)
	@ResponseBody
	public String addAccounts(@RequestBody UserAccount account){
		
		//Added code to add patient as well
		PatientProfile patient = new PatientProfile();
		patient.setUserid(account.getUserid());
		
		Session session = null;
		Transaction tx = null;
		try{
			session = insertdao.getSession();
			tx = session.beginTransaction();
			session.save(account);
			//Added this line to save patient
			session.save(patient);
			tx.commit();
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}

}
