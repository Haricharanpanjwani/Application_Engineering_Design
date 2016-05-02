package com.my.finalproject.webControllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.QuestionDAO;
import com.my.finalproject.model.Answers;


@Controller
public class AnswersController {

	@Autowired
	QuestionDAO questiondao;
	
	@RequestMapping(value="/getallanswers",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<Answers> listAllAnswers(){
		return questiondao.getAllAnswers();
	}
	
	@RequestMapping(value="/editanswers",method=RequestMethod.POST)
	@ResponseBody
	public void eidtThisAccounts(@RequestBody Answers answers){
		questiondao.editAnswers(answers);
	}
	
	@RequestMapping(value="/deleteanswers",method=RequestMethod.POST)
	@ResponseBody
	public String deleteThisAccounts(@RequestBody Answers answers){
		System.out.println(answers.getAnswerid());
		questiondao.deleteAnswer(answers);
		return "success";
	}
}
