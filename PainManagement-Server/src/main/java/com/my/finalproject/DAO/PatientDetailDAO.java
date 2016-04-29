package com.my.finalproject.DAO;

import org.hibernate.Query;
import org.hibernate.Session;

import com.my.finalproject.model.PatientProfile;

public class PatientDetailDAO extends DAO{

		public PatientProfile getProfile(int id){
			try{
				Session session = getSession();
				Query query = session.createQuery("from PatientProfile where userid =:userid");
				query.setString("userid",String.valueOf(id));
				PatientProfile p = (PatientProfile) query.uniqueResult();
				return p;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
}
