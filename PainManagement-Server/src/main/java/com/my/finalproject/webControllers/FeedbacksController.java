package com.my.finalproject.webControllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.FeedBackDAO;
import com.my.finalproject.Feedbackcontrollers.QuestionModel;
import com.my.finalproject.model.ActionFeedback;

@Controller
public class FeedbacksController {
	
	@Autowired
	FeedBackDAO feedbackdao;
	
	
	@RequestMapping(value="/getallfeedbacks",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<QuestionModel> getAllFeedbacks(){
		
		return feedbackdao.listAllFeedback();
		
	}
	
	@RequestMapping(value="/getallactionfeedbacks",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<ActionFeedback> getAllActionFeedbacks(){
		
		return feedbackdao.listAllActionFeedback();
		
	}
	
}
