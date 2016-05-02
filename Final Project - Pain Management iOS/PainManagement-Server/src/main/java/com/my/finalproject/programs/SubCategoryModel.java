package com.my.finalproject.programs;

import java.util.ArrayList;


public class SubCategoryModel {
	
	private ArrayList<TempProgramModel> list ;
	private String subcategoryname;
	
	public SubCategoryModel(){
		this.list = new ArrayList<TempProgramModel>();
	}
	
	public ArrayList<TempProgramModel> getList() {
		return list;
	}
	public void setList(ArrayList<TempProgramModel> list) {
		this.list = list;
	}
	public String getSubcategoryname() {
		return subcategoryname;
	}
	public void setSubcategoryname(String subcategoryname) {
		this.subcategoryname = subcategoryname;
	}
	
	

}
