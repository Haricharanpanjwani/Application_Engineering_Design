package com.spring.forensic.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

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

	public List getDistributor() {
		
		Session session = getSession();
		Query query = session.createQuery("from Enterprise where role =:un");
		query.setParameter("un", "Distributor");
		List distributorList = query.list();
		return distributorList;
	}

	public List getManufacturer() {
		
		Session session = getSession();
		Query query = session.createQuery("from Enterprise where role =:un");
		query.setParameter("un", "Manufacturer");
		List manufacturerList = query.list();
		return manufacturerList;
	}

	public List<Enterprise> getEnterprise()	{

		Session session = getSession();
		Query query = session.createQuery("from Enterprise");
		List enterpriseList = query.list();
		return enterpriseList;
	}
}
