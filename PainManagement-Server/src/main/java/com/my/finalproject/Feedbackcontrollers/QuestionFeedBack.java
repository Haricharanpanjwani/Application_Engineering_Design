package com.my.finalproject.Feedbackcontrollers;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.InsertDAO;


@Controller
public class QuestionFeedBack {
	
	@Autowired
	InsertDAO insertdao;
	
	@RequestMapping(value="/questionfeedback",method=RequestMethod.POST)
	@ResponseBody
	public String storeAnswer(@RequestBody QuestionfeedbackList models){
		Session session = insertdao.getSession();
		try{
			Transaction tx = session.beginTransaction();
			for(QuestionModel model : models){
				session.save(model);
			}
			tx.commit();
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			if(session != null){
				session.close();
			}
		}
		
	}

}
