package com.spring.forensic.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WorkRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestId;		
	
	@Column(name = "drugName")
	private String drugName;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "senderId")
	private Enterprise enterpriseSender;
	
	@ManyToOne
	@JoinColumn(name = "receiverId")
	private Enterprise enterpriseReceiver;

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Enterprise getEnterpriseSender() {
		return enterpriseSender;
	}

	public void setEnterpriseSender(Enterprise enterpriseSender) {
		this.enterpriseSender = enterpriseSender;
	}

	public Enterprise getEnterpriseReceiver() {
		return enterpriseReceiver;
	}

	public void setEnterpriseReceiver(Enterprise enterpriseReceiver) {
		this.enterpriseReceiver = enterpriseReceiver;
	}
	
}
