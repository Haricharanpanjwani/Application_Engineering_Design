package com.yusuf.spring.pojo;

public class Email {

	private long id;
    private String emailId;
    private User user;
    
    public Email(){}
    
    public Email(String emailId){
    	this.emailId = emailId;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}
