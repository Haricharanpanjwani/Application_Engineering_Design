package com.my.finalproject.DAO;

import org.hibernate.Session;

public abstract class DAO {
	
	public Session getSession(){
		return HibernateUtil.getSessionFactory().openSession();
	}
	
	
}
