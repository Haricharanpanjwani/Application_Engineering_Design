package com.spring.forensic.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.spring.forensic.pojo.Drug;
import com.spring.forensic.pojo.UserAccount;

public class UserAccountDao extends DAO {

	public void saveUserAccount(UserAccount userAccount) {
		try {
			begin();
			getSession().save(userAccount);
			commit();

		} catch (Exception ex) {
			System.out.println("UserAccountDao Exception" + ex);
			rollback();
		}
	}
	
	public List<UserAccount> getUserAccount()	{
		Session session = getSession();
		Query query= session.createQuery("from UserAccount");
		List userList = query.list();
		return userList;
	}

	public UserAccount userAuthentication(String userName, String password) {
		
		Session session = getSession();
		Query query = session.createQuery("from UserAccount where userName=:x and password=:y");
		query.setParameter("x", userName);
		query.setParameter("y", password);
		UserAccount userAccount = (UserAccount) query.uniqueResult();
		return userAccount;
	}

	public UserAccount checkUserName(String userName) {
		
		Session session = getSession();
		Query query = session.createQuery("from UserAccount where userName=:user");
		query.setParameter("user", userName);
		UserAccount findUserAccount = null;
		findUserAccount = (UserAccount) query.uniqueResult();
		return findUserAccount;
	}
	
	public List<UserAccount> getAllUserAccount(String filter) {
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(UserAccount.class);
		
		criteria.add(Restrictions.ilike("role","Manufacturer"));
//		if(filter.equals("desc")) {					
//			criteria.addOrder(Order.desc("drugName"));
//		} else if(filter.equals("asc")) {
//			criteria.addOrder(Order.asc("drugName"));
//		} else if(filter.equals("100")) {
//			criteria.add(Restrictions.gt("quantity", 100));
//			criteria.addOrder(Order.asc("quantity"));
//		}
//		else if(filter.equals("200")) {
//			criteria.add(Restrictions.gt("quantity", 200));
//			criteria.addOrder(Order.asc("quantity"));
//		}
		
		List<UserAccount> userAccountList = criteria.list();
		
		return userAccountList;
	}
}
