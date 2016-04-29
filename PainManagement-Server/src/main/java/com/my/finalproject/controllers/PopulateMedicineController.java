package com.my.finalproject.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.Medicinemodel.MedicineAndPatient;
import com.my.finalproject.Medicinemodel.MedicineDAO;
import com.my.finalproject.model.UserAccount;


@Controller
public class PopulateMedicineController {
		
	@Autowired
	MedicineDAO medicinedao;
	
	@RequestMapping(value ="/medicine",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<MedicineAndPatient> listMedicine(@RequestBody UserAccount ua){
		
		return medicinedao.getPatientMedicine(ua.getUserid());
	}
	
	@RequestMapping(value ="/showmedicine",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<MedicineAndPatient> showMedicine(){
		return medicinedao.showMedicine();
	}
	
}
