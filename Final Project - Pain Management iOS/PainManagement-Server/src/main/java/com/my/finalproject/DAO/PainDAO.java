package com.my.finalproject.DAO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import com.my.finalproject.model.PainCategory;

@SuppressWarnings("unchecked")
public class PainDAO extends DAO{
	
	public ArrayList<PainCategory> listpain(int id){
		
		ArrayList<PainCategory> list = new ArrayList<PainCategory>();
		
		try {
			Session session = getSession();
			Query query = session.createQuery("select painid from UserPainDetails where userid =:userid");	
			query.setString("userid", String.valueOf(id));
			ArrayList<Integer> userpainlist = (ArrayList<Integer>) query.list();
			
			Query painQuery = session.createQuery("from PainCategory");
			ArrayList<PainCategory>  allpain =  (ArrayList<PainCategory>) painQuery.list();
			
			for(PainCategory p : allpain){
				int j = p.getPainid();
				for(int i = 0;i<userpainlist.size();i++){
					if(j == userpainlist.get(i)){
						list.add(p);
					}
				}
			}
			
			if(list != null){
				System.out.println("nothing");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	

}
