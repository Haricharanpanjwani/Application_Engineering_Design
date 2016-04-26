package com.spring.forensic.dao;

import java.util.List;

import org.bouncycastle.asn1.isismtt.x509.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.cache.annotation.Cacheable;

import com.spring.forensic.pojo.Drugs;
import com.spring.forensic.pojo.Enterprises;

public class EnterprisesDao extends DAO {

	public void saveEnterprises(Enterprises enterprises)	{		
		try	{
			beginTrans();
			getSession().save(enterprises);
			commitTrans();
		}
		catch (Exception e)	{
			System.out.println("Exception in saving Enterprise " + e);
			rollbackTrans();
		}
	}

	public Enterprises getEnterprisesByName(String name) {
		
		Session session = getSession();
		Query enterpriseQuery = session.createQuery("from Enterprises where enterpriseName = :name");
		enterpriseQuery.setParameter("name", name);
		Enterprises enterprises = (Enterprises) enterpriseQuery.uniqueResult();
		return enterprises;
	}

	public Enterprises getEnterprisesById(int enterpriseID) {

		Session session = getSession();
		Query enterpriseQuery = session.createQuery("from Enterprises where enterpriseId = :enterpriseID");
		enterpriseQuery.setParameter("enterpriseID", enterpriseID);
		Enterprises enterprise = (Enterprises) enterpriseQuery.uniqueResult();
		return enterprise;
	}

	public Enterprises checkEnterprisesByName(String enterprisesName)	{

		Session session = getSession();
		Query enterpriseQuery = session.createQuery("from Enterprises where enterpriseName = :enterpriseName");
		enterpriseQuery.setParameter("enterpriseName", enterprisesName);
		Enterprises enterprises = null;
		enterprises = (Enterprises) enterpriseQuery.uniqueResult();
		return enterprises;
	}
	
	@Cacheable(value = "getEnterprise")
	public List<Enterprises> getEnterprises(String filter, String search)	{

		Session session = getSession();
		
		Criteria criteria = session.createCriteria(Enterprises.class);
		criteria.add(Restrictions.ilike("enterpriseName", search, MatchMode.ANYWHERE));
		
		if(filter.equalsIgnoreCase("Manufacturer")) {
			criteria.add(Restrictions.ilike("role", "Manufacturer"));
			criteria.add(Restrictions.ilike("enterpriseName", search, MatchMode.ANYWHERE));
		}
		else if(filter.equalsIgnoreCase("Distributor")) {
			criteria.add(Restrictions.ilike("role", "Distributor"));
			criteria.add(Restrictions.ilike("enterpriseName", search, MatchMode.ANYWHERE));
		}
		else if(filter.equalsIgnoreCase("Dispenser")) {
			criteria.add(Restrictions.ilike("role", "Dispenser"));
			criteria.add(Restrictions.ilike("enterpriseName", search, MatchMode.ANYWHERE));
		}
		
		List<Enterprises> enterpriseList = criteria.list();
		
		return enterpriseList;
	}
}
