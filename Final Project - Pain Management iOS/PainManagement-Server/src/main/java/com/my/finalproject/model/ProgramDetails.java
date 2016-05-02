package com.my.finalproject.model;

public class ProgramDetails {
	
	private int programid;
	private String programname;
	private byte[] programdetail;
	private String programurl;
	private int subcategory;
	private String programtype;
	
	public String getProgramtype() {
		return programtype;
	}
	public void setProgramtype(String programtype) {
		this.programtype = programtype;
	}
	public String getProgramurl() {
		return programurl;
	}
	public void setProgramurl(String programurl) {
		this.programurl = programurl;
	}
	public int getProgramid() {
		return programid;
	}
	public void setProgramid(int programid) {
		this.programid = programid;
	}
	public String getProgramname() {
		return programname;
	}
	public void setProgramname(String programname) {
		this.programname = programname;
	}
	
	public byte[] getProgramdetail() {
		return programdetail;
		
	}
	public void setProgramdetail(byte[] programdetail) {
		this.programdetail = programdetail;
	}
	
	public int getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(int subcategory) {
		this.subcategory = subcategory;
	}
	
	
	
	

}
