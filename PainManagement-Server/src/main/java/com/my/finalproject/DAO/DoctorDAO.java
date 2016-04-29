package com.my.finalproject.DAO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import com.my.finalproject.model.DoctorProfile;

public class DoctorDAO extends DAO{
	
	@SuppressWarnings("unchecked")
	public ArrayList<DoctorProfile> getDoctors(){
		
		Session session = null;
		ArrayList<DoctorProfile> doctorList = new ArrayList<DoctorProfile>();
		
		try{
			session = getSession();
			Query docQuery = session.createQuery("from DoctorProfile");
			doctorList = (ArrayList<DoctorProfile>)docQuery.list();
			return doctorList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public DoctorProfile showDoctor(int id){
		
		Session session = null;
		
		try{
			session = getSession();
			Query patientquery = session.createQuery("select doctorid from PatientProfile where userid =:userid");
			patientquery.setString("userid",String.valueOf(id));
			int did = (Integer) patientquery.uniqueResult();
			
			Query query = session.createQuery("from DoctorProfile where doctorid =:doctorid");
			query.setString("doctorid", String.valueOf(did));
			DoctorProfile d = (DoctorProfile) query.uniqueResult();
			return d;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			if(session != null){
				session.close();
			}
		}
		
	}

}
