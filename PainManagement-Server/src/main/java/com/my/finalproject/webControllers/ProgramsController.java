package com.my.finalproject.webControllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.ProgramDAO;
import com.my.finalproject.model.MainCategory;
import com.my.finalproject.model.SubCategory;
import com.my.finalproject.programs.TempProgramModel;



@Controller
public class ProgramsController {
	
	@Autowired
	ProgramDAO programdao;
	
	@RequestMapping(value="/showmaincategory",method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<MainCategory> showMainCategory(){
		return programdao.listMainCategory();
	}
	
	@RequestMapping(value="/showsubcategory",method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<SubCategory> showSubCategory(){
		return programdao.listSubCategory();
	}
	
	@RequestMapping(value="/showprogramdetails",method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<TempProgramModel> showProgramDetails(){
		return programdao.listProgramDetails();
	}
}
