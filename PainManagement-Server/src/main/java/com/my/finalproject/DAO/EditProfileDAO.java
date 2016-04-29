package com.my.finalproject.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.my.finalproject.editprofile.EditPatientProfileModel;
import com.my.finalproject.model.PatientProfile;

public class EditProfileDAO extends DAO{
	
	
	public String editProfile(EditPatientProfileModel model){
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();
			tx = session.beginTransaction();
			
			System.out.println(model.getUserid());
			
			Query query = session.createQuery("from PatientProfile where userid =:userid");
			query.setString("userid", String.valueOf(model.getUserid()));
			
			PatientProfile profile = (PatientProfile) query.uniqueResult();	
			
			if(profile != null){
				System.out.println("I have some one here");
			}
			profile.setFirstname(model.getFirstname());
			profile.setLastname(model.getLastname());
			profile.setGender(model.getGender());
			
			tx.commit();
			return "success";
			
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
		finally{
			if(session != null){
				session.close();
			}
		}
		
		
	}
		

}
