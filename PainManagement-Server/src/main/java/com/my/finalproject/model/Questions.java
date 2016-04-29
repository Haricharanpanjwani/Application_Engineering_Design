package com.my.finalproject.model;

public class Questions {

		private int questionid;
		private String questiondetail;
		private int answerid;
		private String questionType;
		
		
		
		public String getQuestionType() {
			return questionType;
		}
		public void setQuestionType(String questionType) {
			this.questionType = questionType;
		}
		public int getAnswerid() {
			return answerid;
		}
		public void setAnswerid(int answerid) {
			this.answerid = answerid;
		}
		public int getQuestionid() {
			return questionid;
		}
		public void setQuestionid(int questionid) {
			this.questionid = questionid;
		}
		public String getQuestiondetail() {
			return questiondetail;
		}
		public void setQuestiondetail(String questiondetail) {
			this.questiondetail = questiondetail;
		}
		
		
}
