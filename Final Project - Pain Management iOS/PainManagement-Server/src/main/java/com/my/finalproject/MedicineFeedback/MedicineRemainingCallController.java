package com.my.finalproject.MedicineFeedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MedicineRemainingCallController {
	
	@Autowired
	MedicineRemainingDAO medicineremainingdao;
	
	
	@RequestMapping(value="/getremaining",method=RequestMethod.POST)
	@ResponseBody
	public String storeMedicineFeedback(@RequestBody MedicineFeedbackModel mfbm){
		int remainingAmount = medicineremainingdao.findRemain(mfbm);
		return String.valueOf(remainingAmount);
	}
}
