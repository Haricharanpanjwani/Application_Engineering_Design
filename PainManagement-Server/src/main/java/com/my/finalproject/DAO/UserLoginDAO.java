package com.my.finalproject.DAO;


import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.my.finalproject.model.UserAccount;
import com.my.finalproject.webModel.WebUserAccount;

public class UserLoginDAO extends DAO {

	public UserAccount auth(String username, String password){
		UserAccount ua = null;
		Session session = null;
		try{
			session = getSession();
			Query query = session.createQuery("from UserAccount where username =:username and userpassword =:userpassword");
			query.setString("username", username);
			query.setString("userpassword", password);
			ua = (UserAccount) query.uniqueResult();
			System.out.println(ua.getUsername());
			return ua;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<UserAccount> populateAccounts(){
		Session session = null;
		ArrayList<UserAccount> accountList = new ArrayList<UserAccount>();
		try{
			session = getSession();
			Query query = session.createQuery("from UserAccount");
			accountList = (ArrayList<UserAccount>) query.list();
			return accountList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public void editAccount(WebUserAccount useraccount){
		
		Session session = null;
		Transaction tx = null;
		int userid = useraccount.getPreuserid();
		
		System.out.println(useraccount);
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			
			Query query = session.createQuery("from UserAccount where userid =:userid");
			query.setString("userid", String.valueOf(userid));
			UserAccount ua = (UserAccount) query.uniqueResult();
			ua.setUsername(useraccount.getUsername());
			ua.setUserpassword(useraccount.getPassword());
			ua.setStatus(useraccount.getStatus());
			//ua.setUserid(useraccount.getUserid());
			
			tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public void deactiveUser(WebUserAccount useraccount){
		Session session = null;
		Transaction tx = null;
		int userid = useraccount.getPreuserid();
		
		System.out.println(useraccount);
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			
			Query query = session.createQuery("from UserAccount where userid =:userid");
			query.setString("userid", String.valueOf(userid));
			UserAccount ua = (UserAccount) query.uniqueResult();
			ua.setStatus(0);
			//ua.setUserid(useraccount.getUserid());
			
			tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public void deleteUser(UserAccount useraccount){
		
		Session session = null;
		
		try{
			session = getSession();
			Query query = session.createQuery("from UserAccount where userid =:userid");
			query.setString("userid", String.valueOf(useraccount.getUserid()));
			UserAccount ua = (UserAccount) query.uniqueResult();
			session.delete(ua);
			session.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	
}
