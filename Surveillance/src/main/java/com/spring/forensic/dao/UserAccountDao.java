package com.spring.forensic.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

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

}
