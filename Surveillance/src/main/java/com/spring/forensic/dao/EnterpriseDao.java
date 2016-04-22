package com.spring.forensic.dao;

import java.util.List;

import org.bouncycastle.asn1.isismtt.x509.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.spring.forensic.pojo.Enterprise;

public class EnterpriseDao extends DAO {

	public void saveEnterprise(Enterprise enterprise)	{		
		try	{
			begin();
			getSession().save(enterprise);
			commit();
		}
		catch (Exception e)	{
			System.out.println("EnterpriseDao Exception " + e);
			rollback();
		}
	}

	public Enterprise getEnterpriseByName(String name) {
		
		Session session = getSession();
		Query query = session.createQuery("from Enterprise where enterpriseName = :un");
		query.setParameter("un", name);
		Enterprise enterprise = (Enterprise) query.uniqueResult();
		return enterprise;
	}

	public Enterprise getEnterpriseById(int id) {

		Session session = getSession();
		Query query = session.createQuery("from Enterprise where enterpriseId = :un");
		query.setParameter("un", id);
		Enterprise enterprise = (Enterprise) query.uniqueResult();
		return enterprise;
	}

	public Enterprise checkEnterpriseByName(String enterpriseName)	{

		Session session = getSession();
		Query query = session.createQuery("from Enterprise where enterpriseName = :un");
		query.setParameter("un", enterpriseName);
		Enterprise enterprise = null;
		enterprise = (Enterprise) query.uniqueResult();
		return enterprise;
	}

	public List<Enterprise> getEnterprise(String filter)	{

		Session session = getSession();
		
		Criteria criteria = session.createCriteria(Enterprise.class);
		
		if(filter.equalsIgnoreCase("Manufacturer")) {
			criteria.add(Restrictions.ilike("role", "Manufacturer"));
		}
		else if(filter.equalsIgnoreCase("Distributor")) {
			criteria.add(Restrictions.ilike("role", "Distributor"));
		}
		else if(filter.equalsIgnoreCase("Dispenser")) {
			criteria.add(Restrictions.ilike("role", "Dispenser"));
		}
		
		List<Enterprise> enterpriseList = criteria.list();
		return enterpriseList;
	}
	
//	public List getDistributor() {
//	
//	Session session = getSession();
//	Query query = session.createQuery("from Enterprise where role =:un");
//	query.setParameter("un", "Distributor");
//	List distributorList = query.list();
//	return distributorList;
//}

//public List getManufacturer() {
//	
//	Session session = getSession();
//	Query query = session.createQuery("from Enterprise where role =:un");
//	query.setParameter("un", "Manufacturer");
//	List manufacturerList = query.list();
//	return manufacturerList;
//}
}
