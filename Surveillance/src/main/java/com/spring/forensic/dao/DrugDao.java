package com.spring.forensic.dao;

import java.util.List;

import org.bouncycastle.asn1.isismtt.x509.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.spring.forensic.pojo.Drug;
import com.spring.forensic.pojo.Enterprise;

public class DrugDao extends DAO {
	
	public void saveDrug(Drug drug)	{
		try	{
			begin();
			getSession().save(drug);
			commit();
		}
		catch (Exception e)	{
			System.out.println("DrugDao Exception " + e);
			rollback();
		}
	}
	
	public List getDrug(Enterprise enterprise)	{

		Session session = getSession();
		Query query = session.createQuery("from Drug where enterprise.enterpriseId =:enterpriseID");
		query.setParameter("enterpriseID", enterprise.getEnterpriseId());
		List drugList = query.list();
		return drugList;
	}
	
	public boolean getAva(String drugName, int quantity, Enterprise enterprise, Enterprise se)	{
		
		Session session = getSession();
		Query query = session.createQuery("from Drug where enterprise.enterpriseId =:enterpriseID and drugName =:drugName and quantity >=:quantity");
		query.setParameter("enterpriseID", enterprise.getEnterpriseId());
		query.setParameter("drugName", drugName);
		query.setParameter("quantity", quantity);

		Drug d = (Drug) query.uniqueResult();

		if(d == null)
			return false;
		else	{	
			
			Query drugFetchQuery = session.createQuery("from Drug where enterprise.enterpriseId =:enterpriseID and drugName =:dn");
			drugFetchQuery.setParameter("enterpriseID", se.getEnterpriseId());
			drugFetchQuery.setParameter("dn", drugName);
			
			Drug d1 = (Drug) drugFetchQuery.uniqueResult();
			
			if(d1!=null)
			{
				Transaction transaction = session.beginTransaction();
				Query updateAmoutQuery = session.createQuery("Update Drug set quantity =:quantity where drugName =:drugName and enterprise.enterpriseId =:zn");
				updateAmoutQuery.setParameter("quantity", d1.getQuantity()+quantity);
				updateAmoutQuery.setParameter("drugName", d1.getDrugName());
				updateAmoutQuery.setParameter("zn", se.getEnterpriseId());
				
				int numberOfRows = updateAmoutQuery.executeUpdate();
				
				Query updateExpiryDateQuery = session.createQuery("update Drug set expiryDate=:newq "+"where drugId =:id");				
				updateExpiryDateQuery.setParameter("newq",d.getExpiryDate());
				updateExpiryDateQuery.setParameter("id",d1.getDrugId());				
				
				int rowCount1 = updateExpiryDateQuery.executeUpdate();				
				
				int original = d.getQuantity();
				int newQuantity = original - quantity;
				
				Query updateDrugQuery = session.createQuery("update Drug set quantity=:newq "+"where drugId =:id");				
				updateDrugQuery.setParameter("newq",newQuantity);
				updateDrugQuery.setParameter("id",d.getDrugId());
				int rowCount = updateDrugQuery.executeUpdate();
				
				transaction.commit();
				return true;
			}
			else	{
				
				Drug drug = new Drug();
				drug.setDrugName(drugName);
				drug.setQuantity(quantity);
				drug.setEnterprise(se);
				drug.setExpiryDate(d.getExpiryDate());
				saveDrug(drug);
			
				int original = d.getQuantity();
				int newQuantity = original - quantity;
			
				Transaction transaction = session.beginTransaction();
				Query updateQuantityQuery = session.createQuery("update Drug set quantity=:newq "+"where drugId =:id");
				updateQuantityQuery.setParameter("newq",newQuantity );
				updateQuantityQuery.setParameter("id",d.getDrugId());
				
				int rowCount = updateQuantityQuery.executeUpdate();
			
				transaction.commit();
				return true;
			}
		}
	}
	
	public boolean check(Enterprise enterprise , String drugName, int i,  String exp)	{
		
		Session session = getSession();
		Query query = session.createQuery("from Drug where enterprise.enterpriseId =:enterpriseID and drugName =:drugName");		
		query.setParameter("enterpriseID", enterprise.getEnterpriseId());
		query.setParameter("drugName", drugName);

		Drug drug = (Drug) query.uniqueResult();
		
		if(drug == null)
			return false;
		else	{
			
			Transaction transaction = session.beginTransaction();
			Query updateDrugQuery = session.createQuery("update Drug set quantity=:newq "+"where drugId =:id");			
			updateDrugQuery.setParameter("newq",drug.getQuantity()+i);
			updateDrugQuery.setParameter("id",drug.getDrugId());
			int rowCount = updateDrugQuery.executeUpdate();
			
			Query updateExpiryDateQuery = session.createQuery("update Drug set expiryDate=:newq "+"where drugId =:id");			
			updateExpiryDateQuery.setParameter("newq",exp);
			updateExpiryDateQuery.setParameter("id",drug.getDrugId());
			int numberOfRows = updateExpiryDateQuery.executeUpdate();
			
			transaction.commit();			
			return true;
		}
	}
	
	public List<Drug> getAllDrugs(String filter)	{
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(Drug.class);
		
		if(filter.equals("desc")) {					
			criteria.addOrder(Order.desc("drugName"));
		} else if(filter.equals("asc")) {
			criteria.addOrder(Order.asc("drugName"));
		} else if(filter.equals("100")) {
			criteria.add(Restrictions.gt("quantity", 100));
			criteria.addOrder(Order.asc("quantity"));
		}
		else if(filter.equals("200")) {
			criteria.add(Restrictions.gt("quantity", 200));
			criteria.addOrder(Order.asc("quantity"));
		}
		
		List<Drug> drugList = criteria.list();
	
		return drugList;
	}
}
