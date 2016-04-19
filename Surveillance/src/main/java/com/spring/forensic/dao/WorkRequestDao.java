package com.spring.forensic.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.spring.forensic.pojo.Enterprise;
import com.spring.forensic.pojo.WorkRequest;


public class WorkRequestDao extends DAO {
	
	public void save(WorkRequest workRequest)	{
		try	{
			begin();
			getSession().save(workRequest);
			commit();
		}
		catch (Exception e)	{
			System.out.println("WorkRequestDao Exception " + e);
			rollback();
		}
	}

	
	public List getSenderRequest(int id)	{

		Session session = getSession();
		Query query = session.createQuery("from WorkRequest where enterpriseSender.enterpriseId =:un");
		query.setParameter("un", id);
		List senderList = query.list();
		return senderList;
	}
	
	public List getReceiverRequest(int id)	{

		Session session = getSession();
		Query query = session.createQuery("from WorkRequest where enterpriseReceiver.enterpriseId =:un");
		query.setParameter("un", id);
		List receiverList = query.list();
		return receiverList;
	}
	
	public String getDrugName(int id)	{

		Session session = getSession();
		Query query = session.createQuery("from WorkRequest where requestId =:un");
		query.setParameter("un", id);
		WorkRequest wrorkRequest = (WorkRequest) query.uniqueResult();
		
		Query query1 = session.createQuery("from WorkRequest where status =:kn and requestId =:un");
		query1.setParameter("un", id);
		query1.setParameter("kn","Processed");

		WorkRequest requestedWorkRequest = (WorkRequest) query1.uniqueResult();
		
		
		if(wrorkRequest == null || requestedWorkRequest != null)
			return "no";
		else
			return wrorkRequest.getDrugName();

	}
	
	public int getQuantity(int id)	{

		Session session = getSession();
		Query query = session.createQuery("from WorkRequest where requestId =:un");
		query.setParameter("un", id);
		WorkRequest workRequest = (WorkRequest) query.uniqueResult();
		return workRequest.getQuantity();
	}
	
	public Enterprise getSendere(int id)	{

		Session session = getSession();
		Query query = session.createQuery("from WorkRequest where requestId =:un");
		query.setParameter("un", id);
		WorkRequest workRequest = (WorkRequest) query.uniqueResult();
		return workRequest.getEnterpriseSender();
	}
	
	public void update(int id)	{

		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("update WorkRequest set status =:un "+"where requestId =:id");
		query.setParameter("un", "Processed");
		query.setParameter("id", id);
		System.out.println("qu2"+id);
		
		int rowCount = query.executeUpdate();
		System.out.println("qu2"+rowCount);
		tx.commit();
	}
}
