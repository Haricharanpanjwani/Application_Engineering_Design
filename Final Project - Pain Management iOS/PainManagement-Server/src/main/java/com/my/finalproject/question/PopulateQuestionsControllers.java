package com.my.finalproject.question;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.QuestionDAO;


@Controller
public class PopulateQuestionsControllers {

		@Autowired
		QuestionDAO questiondao;
		
		@RequestMapping(value="/questions",method=RequestMethod.POST)
		@ResponseBody
		public ArrayList<QuestionModel> listQuestions(@RequestBody QuestionType questiontype){
			//Locale locale = new Locale("en", "US");
			//ResourceBundle resourcebundle = ResourceBundle.getBundle("com.my.finalproject.localization.message", locale);
			
			System.out.println(questiontype);
			ArrayList<QuestionModel> list = questiondao.listQuestion(questiontype);
			
			//for(QuestionModel qm : list){
				//System.out.println(qm.getQuestion().getQuestiondetail());
				//qm.getQuestion().setQuestiondetail(resourcebundle.getString(qm.getQuestion().getQuestiondetail()));
				//miss instruction locale
				
			//}
			return list;
		}
	
}
