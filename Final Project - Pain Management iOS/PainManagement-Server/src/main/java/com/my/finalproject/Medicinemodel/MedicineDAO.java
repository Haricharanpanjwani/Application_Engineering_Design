package com.my.finalproject.Medicinemodel;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.my.finalproject.DAO.DAO;

@SuppressWarnings("unchecked")
public class MedicineDAO extends DAO{
	
	@SuppressWarnings("rawtypes")
	public ArrayList<MedicineAndPatient> getPatientMedicine(int id){
		
			Session session = null;
		try{
			 session = getSession();
			Query query = session.createQuery("from MedicineAndPatient where userid =:userid");
			query.setString("userid", String.valueOf(id));
			List list = query.list();
			return (ArrayList<MedicineAndPatient>) list;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList<MedicineAndPatient> showMedicine(){
		Session session = null;
		try{
			session = getSession();
			Query query = session.createQuery("from MedicineAndPatient");
			List list = query.list();
			return (ArrayList<MedicineAndPatient>) list;
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
