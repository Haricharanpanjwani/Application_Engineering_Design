package com.my.finalproject.MedicineFeedback;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.my.finalproject.DAO.DAO;

public class MedicineRemainingDAO extends DAO{
	
	public int getRemainingMedicine(MedicineFeedbackModel mfbm){
		
		Session session = null;
		MedicineFeedbackModel mm = null;
		Transaction tx =  null;
		try{
			session = getSession();
			Query listRemaining = session.createQuery("from MedicineFeedbackModel where mpid =:mpid and date =:date");
			listRemaining.setString("mpid",String.valueOf(mfbm.getMpid()));
			listRemaining.setString("date", mfbm.getDate());
			mm = (MedicineFeedbackModel) listRemaining.uniqueResult();
			if(mm != null){
				tx = session.beginTransaction();
				String history = mfbm.getmHistory() + mm.getmHistory();
				mm.setmHistory(history);
				mm.setTotalAmount(mfbm.getTotalAmount());
				tx.commit();
				return mm.getTotalAmount();
			}else{
				return -2;
			}
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}finally{
			if(session != null){
				session.close();
			}
		}
			
	}
	
	public int findRemain(MedicineFeedbackModel mfbm){
		Session session = null;
		MedicineFeedbackModel mm = null;
		
		try{
			session = getSession();
			Query query = session.createQuery("from MedicineFeedbackModel where mpid =:mpid and date =:date");
			query.setString("mpid",String.valueOf(mfbm.getMpid()));
			query.setString("date", mfbm.getDate());
			mm = (MedicineFeedbackModel) query.uniqueResult();
			if(mm != null){
				return mm.getTotalAmount();
			}else{
				return 0;
			}
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	
}
