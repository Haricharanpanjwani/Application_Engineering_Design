package com.my.finalproject.MedicineFeedback;

public class MedicineFeedbackModel {
	
	private String timeStamp;
	private String date;
	private String mHistory;
	private int mpid;
	private int totalAmount;
	
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getmHistory() {
		return mHistory;
	}
	public void setmHistory(String mHistory) {
		this.mHistory = mHistory;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getMpid() {
		return mpid;
	}
	public void setMpid(int mpid) {
		this.mpid = mpid;
	}

}
