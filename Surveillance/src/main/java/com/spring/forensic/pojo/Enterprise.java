package com.spring.forensic.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Enterprise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int enterpriseId;
	
	private String enterpriseName;
	
	private String role;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="enterprise")
	private List<Drug> drugList;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="enterpriseSender")
	private List<WorkRequest> senderRequestList;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="enterpriseReceiver")
	private List<WorkRequest> receiverRequestList;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="enterprise")
	private UserAccount userAccount;
	
	public UserAccount getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	public List<Drug> getDrugList() {
		return drugList;
	}
	public void setDrugList(List<Drug> drugList) {
		this.drugList = drugList;
	}
	
	public List<WorkRequest> getSenderRequestList() {
		return senderRequestList;
	}
	
	public void setSenderRequestList(List<WorkRequest> senderRequestList) {
		this.senderRequestList = senderRequestList;
	}
	
	public List<WorkRequest> getReceiverRequestList() {
		return receiverRequestList;
	}
	
	public void setReceiverRequestList(List<WorkRequest> receiverRequestList) {
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
