package com.my.finalproject.Medicinemodel;

public class MedicineAndPatient {
	
	private int mpid;
	private int userid;
	private int medicineid;
	private String medicinedes;
	private String medicinename;
	private int maxquatity;
	private float mdpertime;
	
	
	public float getMdpertime() {
		return mdpertime;
	}
	public void setMdpertime(float mdpertime) {
		this.mdpertime = mdpertime;
	}
	public String getMedicinedes() {
		return medicinedes;
	}
	public void setMedicinedes(String medicinedes) {
		this.medicinedes = medicinedes;
	}
	public String getMedicinename() {
		return medicinename;
	}
	public void setMedicinename(String medicinename) {
		this.medicinename = medicinename;
	}
	
	public int getMaxquatity() {
		return maxquatity;
	}
	public void setMaxquatity(int maxquatity) {
		this.maxquatity = maxquatity;
	}
	public int getMpid() {
		return mpid;
	}
	public void setMpid(int mpid) {
		this.mpid = mpid;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getMedicineid() {
		return medicineid;
	}
	public void setMedicineid(int medicineid) {
		this.medicineid = medicineid;
	}
	

}
