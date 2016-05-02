package com.my.finalproject.webControllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.QuestionDAO;
import com.my.finalproject.model.Questions;

@Controller
public class QuestionsController {
	
	@Autowired
	QuestionDAO questiondao;
	
	
	@RequestMapping(value="/getallquestions",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<Questions> listAllQuestions(){
		return questiondao.getAllQuestions();
	}
	
	@RequestMapping(value="/editquestions",method=RequestMethod.POST)
	@ResponseBody
	public void eidtThisAccounts(@RequestBody Questions questions){
		questiondao.editQuestion(questions);
	}
	
	@RequestMapping(value="/deletequestions",method=RequestMethod.POST)
	@ResponseBody
	public String deleteThisAccounts(@RequestBody Questions questions){
		System.out.println(questions.getQuestionid());
		questiondao.deleteQuestion(questions);
		return "success";
	}
	
}
