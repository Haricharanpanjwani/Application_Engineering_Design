package com.my.finalproject.MedicineFeedback;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.InsertDAO;

@Controller
public class MedicineFeedbackController {
	
	@Autowired
	InsertDAO insertdao;
	
	@Autowired
	MedicineRemainingDAO medicineremainingdao;
	
	
	@RequestMapping(value="/medicinefeedback",method=RequestMethod.POST)
	@ResponseBody
	public String storeMedicineFeedback(@RequestBody MedicineFeedbackModel mfbm){
		
		if(mfbm != null){
			System.out.println(mfbm.getTimeStamp());
		}
		
		int remainingAmount = medicineremainingdao.getRemainingMedicine(mfbm);
		if(remainingAmount == -1){
			return "Server side error!";
		}else if(remainingAmount >= 0){
			return String.valueOf(remainingAmount);
		}else {
			Session session = null;
			Transaction tx = null;
			//System.out.println(mfbm.getMpid());
			try{
				session = insertdao.getSession();
				tx = session.beginTransaction();
				session.save(mfbm);
				tx.commit();
				return "success";
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				if(session != null){
					session.close();
				}
			}
			
		}
	}
	
}
