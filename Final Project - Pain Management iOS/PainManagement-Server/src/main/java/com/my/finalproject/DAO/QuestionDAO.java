package com.my.finalproject.DAO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.my.finalproject.model.AnswerInstruction;
import com.my.finalproject.model.Answers;
import com.my.finalproject.model.Questions;
import com.my.finalproject.question.QuestionModel;
import com.my.finalproject.question.QuestionType;


@SuppressWarnings("unchecked")
public class QuestionDAO extends DAO{
	
	public ArrayList<QuestionModel> listQuestion(QuestionType questiontype){
		try{
			
			System.out.println(questiontype);
			
			ArrayList<QuestionModel> mlist = new ArrayList<QuestionModel>();
			
			Session session = getSession();
			Query questionquery = session.createQuery("from Questions where questiontype =:questiontype");
			questionquery.setString("questiontype", questiontype.getType());
			Query answerquery = session.createQuery("from Answers");
			Query instructionquery = session.createQuery("from AnswerInstruction");
			
			ArrayList<Questions> qlist = (ArrayList<Questions>) questionquery.list();
			ArrayList<Answers> alist = (ArrayList<Answers>) answerquery.list();
			ArrayList<AnswerInstruction> ilist = (ArrayList<AnswerInstruction>) instructionquery.list();
			
			for(Questions q : qlist){
				QuestionModel qm = new QuestionModel();
				qm.setQuestion(q);
				
				for(Answers a : alist){
					if(q.getAnswerid() == a.getAnswerid()){
						qm.setAnswer(a);
					}
				}
				
				for(AnswerInstruction ai : ilist){
					if(q.getAnswerid() == ai.getAnswerid()){
						qm.getInstruction().add(ai);
					}
				}
				mlist.add(qm);
			}
			
			return mlist;
		
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	public ArrayList<Questions> getAllQuestions(){
		
		Session session = null;
		ArrayList<Questions> questions = new ArrayList<Questions>();
		
		try{
			session = getSession();
			Query query = session.createQuery("from Questions");
			questions = (ArrayList<Questions>) query.list();
			return questions;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Answers> getAllAnswers(){
		
		Session session = null;
		ArrayList<Answers> answers = new ArrayList<Answers>();
		
		try{
			session = getSession();
			Query query = session.createQuery("from Answers");
			answers = (ArrayList<Answers>) query.list();
			return answers;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	public ArrayList<AnswerInstruction> getAllAnswersInstructions(){
		
		Session session = null;
		ArrayList<AnswerInstruction> ai = new ArrayList<AnswerInstruction>();
		
		try{
			session = getSession();
			Query query = session.createQuery("from AnswerInstruction");
			ai = (ArrayList<AnswerInstruction>) query.list();
			return ai;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public void editQuestion(Questions questions){
			
			Session session = null;
			Transaction tx = null;
			int questionid = questions.getQuestionid();
			
			try{
				session = getSession();
				tx = session.beginTransaction();
				
				Query query = session.createQuery("from Questions where questionid =:questionid");
				query.setString("questionid", String.valueOf(questionid));
				Questions qu = (Questions) query.uniqueResult();
				qu.setQuestionid(questions.getQuestionid());
				qu.setQuestiondetail(questions.getQuestiondetail());
				qu.setQuestionType(questions.getQuestionType());
				qu.setAnswerid(questions.getAnswerid());
				
				tx.commit();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(session != null){
					session.close();
				}
			}
		}
	
	
	public void deleteQuestion(Questions questions){
		
		Session session = null;
		
		try{
			session = getSession();
			Query query = session.createQuery("from Questions where questionid =:questionid");
			query.setString("questionid", String.valueOf(questions.getQuestionid()));
			Questions qu = (Questions) query.uniqueResult();
			session.delete(qu);
			session.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public void editAnswers(Answers answers){
		
		Session session = null;
		Transaction tx = null;
		int answerid = answers.getAnswerid();
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			
			Query query = session.createQuery("from Answers where answerid =:answerid");
			query.setString("answerid", String.valueOf(answerid));
			Answers answer =  (Answers) query.uniqueResult();
			answer.setAnswerid(answers.getAnswerid());
			answer.setAnswerdetail(answers.getAnswerdetail());
			answer.setAnswertype(answers.getAnswertype());
			
			tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public void deleteAnswer(Answers answers){
		
		Session session = null;
		
		try{
			session = getSession();
			Query query = session.createQuery("from Answers where answerid =:answerid");
			query.setString("answerid", String.valueOf(answers.getAnswerid()));
			Answers an = (Answers) query.uniqueResult();
			session.delete(an);
			session.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public void editAnswerInstruction(AnswerInstruction answerInstruction){
		
		Session session = null;
		Transaction tx = null;
		int insid = answerInstruction.getInstructionid();
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			
			Query query = session.createQuery("from AnswerInstruction where instructionid =:instructionid");
			query.setString("instructionid", String.valueOf(insid));
			AnswerInstruction anin =  (AnswerInstruction) query.uniqueResult();
			anin.setInstructionid(answerInstruction.getInstructionid());
			anin.setInstructiondetail(answerInstruction.getInstructiondetail());
			anin.setAnswerid(answerInstruction.getAnswerid());
			
			tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
	}


	public void deleteAnswerInstruction(AnswerInstruction answerInstruction){
	
	Session session = null;
	
	try{
		session = getSession();
		Query query = session.createQuery("from AnswerInstruction where instructionid =:instructionid");
		query.setString("instructionid", String.valueOf(answerInstruction.getInstructionid()));
		AnswerInstruction anin =  (AnswerInstruction) query.uniqueResult();
		session.delete(anin);
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
