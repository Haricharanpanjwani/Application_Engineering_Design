package com.spring.forensic.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.spring.forensic.pojo.UserAccounts;

public class UserAccountsDao extends DAO {
	
	// Indexing of hibernate search
	public void doIndex() {
				
        try {
        	System.out.println("In do Index");
        	Session session = getSession();
	        FullTextSession fullTextSession = Search.getFullTextSession(session);
	        fullTextSession.createIndexer().startAndWait();
	        
	        //fullTextSession.close();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
	
	// search based on firstName, lastName and userName
	public List<UserAccounts> search(String queryString) {
        
		Session session = getSession();		
		
		FullTextSession fullTextSession = Search.getFullTextSession(session);
         
        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(UserAccounts.class).get();
        org.apache.lucene.search.Query luceneQuery = queryBuilder.keyword().wildcard().onFields("firstName", "lastName", "userName").matching("*"+queryString.toLowerCase()+"*").createQuery();
 
       
        org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, UserAccounts.class);
         
        List<UserAccounts> userAccountList = fullTextQuery.list();
        
        System.out.println("In search " + userAccountList.size());
        
        //fullTextSession.close();
         
        return userAccountList;
    }	
	
	public void saveUserAccounts(UserAccounts userAccounts) {
		try {
			beginTrans();
			getSession().save(userAccounts);
			commitTrans();

		} catch (Exception ex) {
			System.out.println("Exception in saving UserAccount" + ex);
			rollbackTrans();
		}
	}
	
	public List<UserAccounts> getUserAccounts()	{
		Session session = getSession();
		Query fetchQuery= session.createQuery("from UserAccounts");
		List<UserAccounts> usersList = fetchQuery.list();
		return usersList;
	}

	public UserAccounts usersAuthentication(String user, String pasword) {
		
		Session session = getSession();
		Query fetchQuery = session.createQuery("from UserAccounts where userName=:userName and password=:password");
		fetchQuery.setParameter("userName", user);
		fetchQuery.setParameter("password", pasword);
		UserAccounts userAccount = (UserAccounts) fetchQuery.uniqueResult();
		return userAccount;
	}

	public UserAccounts verifyUserName(String user, String email) {
		
//		String user = userAcc.getUserName();
//		String email = userAcc.geteMail();
		
		Session session = getSession();
		Query fetchQuery = session.createQuery("from UserAccounts where userName=:user or eMail = :email");
		fetchQuery.setParameter("user", user);
		fetchQuery.setParameter("email", email);
		UserAccounts findUserAccount = null;
		findUserAccount = (UserAccounts) fetchQuery.uniqueResult();
		return findUserAccount;
	}
	
	public List<UserAccounts> getAllUserAccount(String filter) {
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(UserAccounts.class);
		
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
		
		List<UserAccounts> userAccountList = criteria.list();
		
		return userAccountList;
	}
}
