package com.my.finalproject.webControllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.QuestionDAO;
import com.my.finalproject.model.AnswerInstruction;

@Controller
public class AnswerInstructionsController {
	
	@Autowired
	QuestionDAO questiondao;
	
	
	@RequestMapping(value="/getallanswerinstructions",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<AnswerInstruction> listAllQuestions(){
		return questiondao.getAllAnswersInstructions();
	}
	
	@RequestMapping(value="/editanswersinstruction",method=RequestMethod.POST)
	@ResponseBody
	public void eidtThisAccounts(@RequestBody AnswerInstruction answerInstruction){
		questiondao.editAnswerInstruction(answerInstruction);
	}
	
	@RequestMapping(value="/deleteanswersinstruction",method=RequestMethod.POST)
	@ResponseBody
	public String deleteThisAccounts(@RequestBody AnswerInstruction answerInstruction){
		System.out.println(answerInstruction.getInstructionid());
		questiondao.deleteAnswerInstruction(answerInstruction);;
		return "success";
	}
	
}
