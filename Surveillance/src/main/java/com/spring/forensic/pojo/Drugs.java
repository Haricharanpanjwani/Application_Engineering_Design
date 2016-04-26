package com.spring.forensic.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;


@FilterDef(name="betweenQuantity", parameters = {
									@ParamDef(name="minQuantity", type="integer"),
									@ParamDef(name="maxQuantity", type="integer")
												})
@Filter(name="betweenQuantity", condition=":minQuantity <= quantity and :maxQuantity >= quantity")

@Entity
public class Drugs {
        
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int drugId;
	
	private String drugName;
	
	@Column(name = "quantity")
	private int quantity;
        
	private String expiryDate;
	
	@ManyToOne
	@JoinColumn(name = "enterpriseId")
	private Enterprises enterprise;
	
	public Enterprises getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprises enterprise) {
		this.enterprise = enterprise;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public int getDrugId() {
		return drugId;
	}

	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@Override
	public String toString() {
		return this.drugName;
	}
}
