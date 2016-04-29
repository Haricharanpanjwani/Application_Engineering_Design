package com.my.finalproject.ActionFeedback;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.InsertDAO;
import com.my.finalproject.model.ActionFeedback;


@Controller
public class ActionFeedbackController {
	
	@Autowired
	InsertDAO insertdao;
	
	@RequestMapping(value="/actionfeedback",method=RequestMethod.POST)
	@ResponseBody
	public String insertAction(@RequestBody ActionFeedback afb){
		Session session = insertdao.getSession();
		try{
			Transaction tx = session.beginTransaction();
			session.save(afb);
			tx.commit();
			return "Success";
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
