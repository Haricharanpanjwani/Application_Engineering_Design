package com.my.finalproject.DAO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import com.my.finalproject.Feedbackcontrollers.QuestionModel;
import com.my.finalproject.model.ActionFeedback;


@SuppressWarnings("unchecked")
public class FeedBackDAO extends DAO{

	public ArrayList<QuestionModel> listAllFeedback(){
		
		Session session = null;
		
		try{
			session = getSession();
			Query query = session.createQuery("from QuestionModel");
			ArrayList<QuestionModel> list = (ArrayList<QuestionModel>) query.list();
			return list;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<ActionFeedback> listAllActionFeedback(){
		
		Session session = null;
		
		try{
			session = getSession();
			Query query = session.createQuery("from ActionFeedback");
			ArrayList<ActionFeedback> list = (ArrayList<ActionFeedback>) query.list();
			return list;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
}
