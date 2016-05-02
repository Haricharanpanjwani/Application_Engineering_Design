package com.my.finalproject.programs;

import java.util.ArrayList;

public class MainCategoryModel {

	private ArrayList<SubCategoryModel> list;
	private String categoryname;
	
	public MainCategoryModel(){
		this.list = new ArrayList<SubCategoryModel>();
	}
	
	public ArrayList<SubCategoryModel> getList() {
		return list;
	}
	public void setList(ArrayList<SubCategoryModel> list) {
		this.list = list;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	
}
