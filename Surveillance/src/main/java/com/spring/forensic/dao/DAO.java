package com.spring.forensic.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class DAO {
	
	private static final SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
	private static final ThreadLocal sessionThread = new ThreadLocal();
	
	public Session getSession()
	{
		Session session = (Session) sessionThread.get();
		
		if(session==null) {
			session= sessionFactory.openSession();
			sessionThread.set(session);
		}
		
		return session;
	}
	
	public void begin() {
		getSession().beginTransaction();
	}
	
	public void commit() {
		getSession().getTransaction().commit();
	}
	
	public void close()	{
		getSession().close();
		sessionThread.set(null);
	}

	public void rollback()	{
		
		try	{
			getSession().getTransaction().rollback();
			getSession().close();
			sessionThread.set(null);
		}
		catch(Exception ex)	{
			System.out.println("Exception inside rollback"+ ex);
		}
	}
}
