package com.my.finalproject.Feedbackcontrollers;



public class QuestionModel {

	private String feedbackid;
	private int questionid;
	private String answervalue;
	private int userid;
	private String answertype;
	
	public String getFeedbackid() {
		return feedbackid;
	}
	public void setFeedbackid(String feedbackid) {
		this.feedbackid = feedbackid;
	}
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public String getAnswervalue() {
		return answervalue;
	}
	public void setAnswervalue(String answervalue) {
		this.answervalue = answervalue;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getAnswertype() {
		return answertype;
	}
	public void setAnswertype(String answertype) {
		this.answertype = answertype;
	}
	
	
	
}
