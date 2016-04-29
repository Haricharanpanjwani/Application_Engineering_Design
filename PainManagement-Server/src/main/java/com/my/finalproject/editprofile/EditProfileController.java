package com.my.finalproject.editprofile;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.EditProfileDAO;
import com.my.finalproject.DAO.InsertDAO;
import com.my.finalproject.model.PatientProfile;

@Controller
public class EditProfileController {
	
	@Autowired
	EditProfileDAO editprofiledao;
	
	@Autowired
	InsertDAO insertdao;
	
	@RequestMapping(value="/editprofile",method=RequestMethod.POST)
	@ResponseBody
	public String editProfile(@RequestBody EditPatientProfileModel editmodel){
		//public String editProfile(@RequestBody PatientProfile editmodel)	
		return editprofiledao.editProfile(editmodel);
	}
	
	@RequestMapping(value="/saveprofile",method=RequestMethod.POST)
	@ResponseBody
	public String saveProfile(@RequestBody PatientProfile patientProfile){
		Session session = null;
		Transaction tx = null;
		try{
			session = insertdao.getSession();
			tx = session.beginTransaction();
			session.save(patientProfile);
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
