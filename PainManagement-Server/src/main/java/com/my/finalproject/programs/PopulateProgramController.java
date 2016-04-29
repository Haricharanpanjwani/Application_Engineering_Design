package com.my.finalproject.programs;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.ProgramDAO;

@Controller
public class PopulateProgramController {

	@Autowired
	ProgramDAO programdao;
	
	@RequestMapping(value="/programs",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<MainCategoryModel> listPrograms(){
		Locale locale = new Locale("en", "US");
		ResourceBundle resourcebundle = ResourceBundle.getBundle("com.my.finalproject.localization.message", locale);
		return programdao.populatePrograms(resourcebundle);
	}
	
}
