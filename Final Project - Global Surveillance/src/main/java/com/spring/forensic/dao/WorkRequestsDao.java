package com.spring.forensic.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.spring.forensic.pojo.Enterprises;
import com.spring.forensic.pojo.WorkRequests;

public class WorkRequestsDao extends DAO {
	
	public void saveWorkRequest(WorkRequests workRequests)	{
		try	{
			beginTrans();
			getSession().save(workRequests);
			commitTrans();
		}
		catch (Exception e)	{
			System.out.println("Exception in saving WorkRequest" + e);
			rollbackTrans();
		}
	}
	
	public List getSenderRequests(int enterpriseID)	{

		Session session = getSession();
		Query fetchQuery = session.createQuery("from WorkRequests where enterpriseSender.enterpriseId =:enterpriseID");
		fetchQuery.setParameter("enterpriseID", enterpriseID);
		List senderList = fetchQuery.list();
		return senderList;
	}
	
	public List getReceiverRequests(int enterpriseID)	{
				 
		System.out.println("Enterprise ID: " + enterpriseID);
		
		Session session = getSession();
		Query fetchQuery = session.createQuery("from WorkRequests where enterpriseReceiver.enterpriseId =:enterpriseID");
		fetchQuery.setParameter("enterpriseID", enterpriseID);
		List receiverList = fetchQuery.list();
		return receiverList;
	}
	
	public String getDrugNames(int requestID)	{
		
		Session session = getSession();
		Query fetchQuery = session.createQuery("from WorkRequests where requestId =:requestID");
		fetchQuery.setParameter("requestID", requestID);
		WorkRequests wrorkRequest = (WorkRequests) fetchQuery.uniqueResult();
		
		Query fetchStatusQuery = session.createQuery("from WorkRequests where status =:status and requestId =:requestID");
		fetchStatusQuery.setParameter("requestID", requestID);
		fetchStatusQuery.setParameter("status","Processed");		

		WorkRequests requestedWorkRequest = (WorkRequests) fetchStatusQuery.uniqueResult();
		
		if(wrorkRequest == null || requestedWorkRequest != null)
			return "none";
		else
			return wrorkRequest.getDrugName();
	}
	
	public int getQuantities(int requestID)	{

		Session session = getSession();
		Query fetchQuery = session.createQuery("from WorkRequests where requestId =:requestID");
		fetchQuery.setParameter("requestID", requestID);
		WorkRequests workRequest = (WorkRequests) fetchQuery.uniqueResult();
		return workRequest.getQuantity();
	}
	
	public Enterprises getSenderEnterprise(int requestID)	{

		Session session = getSession();
		Query query = session.createQuery("from WorkRequests where requestId =:requestID");
		query.setParameter("requestID", requestID);
		WorkRequests workRequest = (WorkRequests) query.uniqueResult();
		return workRequest.getEnterpriseSender();
	}
	
	public void updateEnteprise(int requestID)	{

		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Query fetchQuery = session.createQuery("update WorkRequests set status =:status "+"where requestId =:requestID");
		fetchQuery.setParameter("status", "Processed");
		fetchQuery.setParameter("requestID", requestID);
		System.out.println("Work Request ID: "+requestID);
		
		int numberOfRow = fetchQuery.executeUpdate();
		
		tx.commit();
	}
	
	public List reportGenerate() {
		
		Session session = getSession();
		//criteria.add(Restrictions.ilike("role", "Distributor"));
		//criteria.add(Restrictions.ilike("role", "Dispenser"));
		Criteria workRequestCriteria = session.createCriteria(WorkRequests.class);
		
		Criteria enterpriseCriteria = workRequestCriteria.createCriteria("enterpriseSender");
		enterpriseCriteria.add(Restrictions.ilike("role", "Distributor"));
		
		
		ProjectionList projList = Projections.projectionList();
		//Maximum number of order placed
		projList.add(Projections.max("enterpriseSender"));
//		projList.add(Projections.min("quantity"));
//		projList.add(Projections.avg("quantity"));
//		projList.add(Projections.countDistinct("drugName"));
		workRequestCriteria.setProjection(projList);
		
		List<Object[]> results = workRequestCriteria.list();
		
		return results;		
	}
}
