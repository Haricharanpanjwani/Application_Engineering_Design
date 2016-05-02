package com.spring.forensic.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class DAO {
	
	private static final SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
	private static final ThreadLocal threadSession = new ThreadLocal();
	
	public Session getSession()	{
		Session session = (Session) threadSession.get();
		
		if(session==null) {			
			session= sessionFactory.openSession();
			threadSession.set(session);			
		}		
		return session;
	}
	
	public void beginTrans() {
		getSession().beginTransaction();
	}
	
	public void commitTrans() {
		getSession().getTransaction().commit();
	}
	
	public void closeSession()	{
		getSession().close();
		threadSession.set(null);
	}

	public void rollbackTrans()	{
		
		try	{
			getSession().getTransaction().rollback();
			getSession().close();
			threadSession.set(null);
		}
		catch(Exception ex)	{
			System.out.println("Exception inside rollback"+ ex);
		}
	}
}
