package com.spring.forensic.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.cache.annotation.Cacheable;

import com.spring.forensic.pojo.Drugs;
import com.spring.forensic.pojo.Enterprises;

public class DrugsDao extends DAO {
	
	public void saveDrugs(Drugs drugs)	{
		try	{
			beginTrans();
			getSession().save(drugs);
			commitTrans();
		}
		catch (Exception e)	{
			System.out.println("Exception in saving drug " + e);
			rollbackTrans();
		}
	}
	
	@Cacheable(value = "getDrugs")
	public List<Drugs> getDrugs(Enterprises enterprise)	{
		
		Session session = getSession();
		Query query = session.createQuery("from Drugs where enterprise.enterpriseId =:enterpriseID");
		query.setParameter("enterpriseID", enterprise.getEnterpriseId());
		List<Drugs> drugList = query.list();
		
		return drugList;
	}
	
	// Create Hibernate Filter
	public List getDrugWithinRange(int min, int max, String filter) {
		
		Session session = getSession();
		
		session.enableFilter("betweenQuantity").setParameter("minQuantity", min).setParameter("maxQuantity", max);
		
		//Query fetchQuery = session.createQuery("from Drugs");
		//List<Drugs> drugsList = fetchQuery.list();
		Criteria criteria = session.createCriteria(Drugs.class);
		
		if(filter.equals("desc")) {					
			criteria.addOrder(Order.desc("quantity"));
		} else if(filter.equals("asc")) {
			criteria.addOrder(Order.asc("quantity"));
		} 
		
		List<Drugs> drugsList = criteria.list();
		
		for(Drugs drug : drugsList) {
			System.out.println(drug);
		}
		
		return drugsList;		
	}
	
	public boolean getAvailability(String drugName, int quantity, Enterprises enterprise, Enterprises senderEnterprise)	{
		
		Session session = getSession();
		Query drugQuery = session.createQuery("from Drugs where enterprise.enterpriseId =:enterpriseID and drugName =:drugName and quantity >=:quantity");
		drugQuery.setParameter("enterpriseID", enterprise.getEnterpriseId());
		drugQuery.setParameter("drugName", drugName);
		drugQuery.setParameter("quantity", quantity);

		Drugs retrieveDrug = (Drugs) drugQuery.uniqueResult();

		if(retrieveDrug == null)
			return false;
		else	{	
			
			Query drugFetchQuery = session.createQuery("from Drugs where enterprise.enterpriseId =:enterpriseID and drugName =:drugName");
			drugFetchQuery.setParameter("enterpriseID", senderEnterprise.getEnterpriseId());
			drugFetchQuery.setParameter("drugName", drugName);
			
			Drugs drugFetched = (Drugs) drugFetchQuery.uniqueResult();
			
			if(drugFetched!=null)	{
				
				Transaction transaction = session.beginTransaction();
				Query updateAmoutQuery = session.createQuery("Update Drugs set quantity =:quantity where drugName =:drugName and enterprise.enterpriseId =:enterprise");
				updateAmoutQuery.setParameter("quantity", drugFetched.getQuantity()+quantity);
				updateAmoutQuery.setParameter("drugName", drugFetched.getDrugName());
				updateAmoutQuery.setParameter("enterprise", senderEnterprise.getEnterpriseId());
				
				int numberOfRows = updateAmoutQuery.executeUpdate();
				
				Query updateExpiryDateQuery = session.createQuery("update Drugs set expiryDate=:newQuantity "+"where drugId =:drugID");				
				updateExpiryDateQuery.setParameter("newQuantity",retrieveDrug.getExpiryDate());
				updateExpiryDateQuery.setParameter("drugID",drugFetched.getDrugId());				
				
				int totalRows = updateExpiryDateQuery.executeUpdate();				
				
				int initialQuantity = retrieveDrug.getQuantity();
				int updatedQuantity = initialQuantity - quantity;
				
				Query updateDrugQuery = session.createQuery("update Drugs set quantity=:newQuantity "+"where drugId =:drugID");				
				updateDrugQuery.setParameter("newQuantity",updatedQuantity);
				updateDrugQuery.setParameter("drugID",retrieveDrug.getDrugId());
				int rowsCount = updateDrugQuery.executeUpdate();
				
				transaction.commit();
				return true;
			}
			else	{
				
				Drugs updateDrug = new Drugs();
				updateDrug.setDrugName(drugName);
				updateDrug.setQuantity(quantity);
				updateDrug.setEnterprise(senderEnterprise);
				updateDrug.setExpiryDate(retrieveDrug.getExpiryDate());
				saveDrugs(updateDrug);
			
				int initialQuantity = retrieveDrug.getQuantity();
				int updatedQuantity = initialQuantity - quantity;
			
				Transaction transaction = session.beginTransaction();
				Query updateQuantityQuery = session.createQuery("update Drugs set quantity=:newQuantity "+"where drugId =:drugID");
				updateQuantityQuery.setParameter("newQuantity",updatedQuantity );
				updateQuantityQuery.setParameter("drugID",retrieveDrug.getDrugId());
				
				int rowsCount = updateQuantityQuery.executeUpdate();
			
				transaction.commit();
				return true;
			}
		}
	}
	
	public boolean checkDrug(Enterprises enterprise , String drugName, int i,  String expiryDate)	{
		
		Session session = getSession();
		Query fetchQuery = session.createQuery("from Drugs where enterprise.enterpriseId =:enterpriseID and drugName =:drugName");		
		fetchQuery.setParameter("enterpriseID", enterprise.getEnterpriseId());
		fetchQuery.setParameter("drugName", drugName);

		Drugs fetchDrug = (Drugs) fetchQuery.uniqueResult();
		
		if(fetchDrug == null)
			return false;
		else	{
			
			Transaction transaction = session.beginTransaction();
			Query updateDrugQuery = session.createQuery("update Drugs set quantity=:newQuantity "+"where drugId =:drugID");			
			updateDrugQuery.setParameter("newQuantity",fetchDrug.getQuantity()+i);
			updateDrugQuery.setParameter("drugID",fetchDrug.getDrugId());
			int rowsCount = updateDrugQuery.executeUpdate();
			
			Query updateExpiryDateQuery = session.createQuery("update Drugs set expiryDate=:newQuantity "+"where drugId =:drugID");			
			updateExpiryDateQuery.setParameter("newQuantity",expiryDate);
			updateExpiryDateQuery.setParameter("drugID",fetchDrug.getDrugId());
			int numberOfRow = updateExpiryDateQuery.executeUpdate();
			
			transaction.commit();			
			return true;
		}
	}
	
	public List<Drugs> getAllDrugs(String filter)	{		
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(Drugs.class);
		
		if(filter.equals("desc")) {					
			criteria.addOrder(Order.desc("drugName"));
		} 
		else if(filter.equals("asc")) {
			criteria.addOrder(Order.asc("drugName"));
		}
		
		List<Drugs> drugList = criteria.list();
	
		return drugList;
	}
}
