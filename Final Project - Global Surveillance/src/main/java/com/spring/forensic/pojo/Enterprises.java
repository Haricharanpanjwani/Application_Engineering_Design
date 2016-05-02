package com.spring.forensic.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity
//@SequenceGenerator(name="seq", initialValue=2, allocationSize=100)
public class Enterprises {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private int enterpriseId;
	
	private String enterpriseName;
	
	private String role;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="enterprise")
	private List<Drugs> drugList;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="enterpriseSender")
	private List<WorkRequests> senderRequestList;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="enterpriseReceiver")
	private List<WorkRequests> receiverRequestList;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="enterprise")
	private UserAccounts userAccount;
	
	public UserAccounts getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccounts userAccount) {
		this.userAccount = userAccount;
	}
	public List<Drugs> getDrugList() {
		return drugList;
	}
	public void setDrugList(List<Drugs> drugList) {
		this.drugList = drugList;
	}
	
	public List<WorkRequests> getSenderRequestList() {
		return senderRequestList;
	}
	
	public void setSenderRequestList(List<WorkRequests> senderRequestList) {
		this.senderRequestList = senderRequestList;
	}
	
	public List<WorkRequests> getReceiverRequestList() {
		return receiverRequestList;
	}
	
	public void setReceiverRequestList(List<WorkRequests> receiverRequestList) {
		this.receiverRequestList = receiverRequestList;
	}
	
	public int getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	
	public String getEnterpriseName() {
		return enterpriseName;
	}
	
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

}
