package com.my.finalproject.DAO;

import java.util.ArrayList;
import java.util.ResourceBundle;

import org.hibernate.Query;
import org.hibernate.Session;

import com.my.finalproject.model.MainCategory;
import com.my.finalproject.model.ProgramDetails;
import com.my.finalproject.model.SubCategory;
import com.my.finalproject.programs.MainCategoryModel;
import com.my.finalproject.programs.SubCategoryModel;
import com.my.finalproject.programs.TempProgramModel;

@SuppressWarnings("unchecked")
public class ProgramDAO extends DAO{
	
	public ArrayList<MainCategoryModel> populatePrograms(ResourceBundle resourceBundle){
		try{
			
			Session session = getSession();
			Query programquery = session.createQuery("from ProgramDetails");
			Query subcategory = session.createQuery("from SubCategory");
			Query maincategory = session.createQuery("from MainCategory");
			
			ArrayList<ProgramDetails> plist = (ArrayList<ProgramDetails>) programquery.list();
			ArrayList<SubCategory> slist = (ArrayList<SubCategory>) subcategory.list();
			ArrayList<MainCategory> mlist = (ArrayList<MainCategory>) maincategory.list();
	
			ArrayList<MainCategoryModel> populatelist = buildModel(plist, slist, mlist,resourceBundle); 
			return populatelist; 
			
		}catch(Exception e){
			 e.printStackTrace();
			 return null;
		}
		
	}
	
	
	public ArrayList<MainCategoryModel> buildModel(ArrayList<ProgramDetails> plist,ArrayList<SubCategory> slist,ArrayList<MainCategory> mlist,ResourceBundle resourceBundle){
		ArrayList<MainCategoryModel> list = new ArrayList<MainCategoryModel>();
		
		for(MainCategory m : mlist){
			MainCategoryModel mmodel = new MainCategoryModel();
			//mmodel.setCategoryname(resourceBundle.getString(m.getCategoryname()));
			mmodel.setCategoryname(m.getCategoryname());
			for(SubCategory s : slist){
				SubCategoryModel smodel = new SubCategoryModel();
				//smodel.setSubcategoryname(resourceBundle.getString(s.getSubcategoryname()));
				smodel.setSubcategoryname(s.getSubcategoryname());
				if(s.getCategoryid()==m.getCategryid()){
					mmodel.getList().add(smodel);
					System.out.println(mmodel.getCategoryname());
				}
				for(ProgramDetails p : plist){
					if(s.getSubcategoryid() == p.getSubcategory()){
						TempProgramModel pm = new TempProgramModel();
						
						pm.setProgramid(p.getProgramid());
						pm.setProgramtype(p.getProgramtype());
						pm.setProgramurl(p.getProgramurl());
						if(p.getProgramdetail() != null){
							pm.setProgramdetail(new String(p.getProgramdetail()));
						}
						//pm.setProgramname(resourceBundle.getString(pm.getProgramname()));
						pm.setProgramname(p.getProgramname());
						smodel.getList().add(pm);
					}
				}
			}
			list.add(mmodel);
		}
		
		
		return list;
	}
	
	public ArrayList<MainCategory> listMainCategory(){
		
		Session session = null;
		
		try{
			session = getSession();
			Query query = session.createQuery("from MainCategory");
			
			return (ArrayList<MainCategory>) query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<SubCategory> listSubCategory(){
		Session session = null;
		
		try{
			session = getSession();
			Query query = session.createQuery("from SubCategory");
			
			return (ArrayList<SubCategory>) query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<TempProgramModel> listProgramDetails(){
		Session session = null;
		
		try{
			session = getSession();
			Query query = session.createQuery("from ProgramDetails");
			ArrayList<ProgramDetails> plist = new ArrayList<ProgramDetails>();
			plist = (ArrayList<ProgramDetails>) query.list();
			ArrayList<TempProgramModel> tlist = new ArrayList<TempProgramModel>();
			
			for(ProgramDetails p : plist){
				TempProgramModel pm = new TempProgramModel();
				
				pm.setProgramid(p.getProgramid());
				pm.setProgramtype(p.getProgramtype());
				pm.setProgramurl(p.getProgramurl());
				if(p.getProgramdetail() != null){
					String a = new String(p.getProgramdetail());
					pm.setProgramdetail(a);
				}
				pm.setProgramname(p.getProgramname());
				tlist.add(pm);
			}
			return tlist;
			
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		
	}

}
