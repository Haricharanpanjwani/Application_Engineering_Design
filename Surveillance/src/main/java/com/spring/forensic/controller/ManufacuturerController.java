package com.spring.forensic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.forensic.dao.DrugDao;
import com.spring.forensic.dao.EnterpriseDao;
import com.spring.forensic.dao.UserAccountDao;
import com.spring.forensic.dao.WorkRequestDao;
import com.spring.forensic.pojo.Drug;
import com.spring.forensic.pojo.Enterprise;
import com.spring.forensic.pojo.UserAccount;
import com.spring.forensic.pojo.WorkRequest;



@Controller
public class ManufacuturerController {
	
	@Autowired
	private DrugDao drugDao;
	
	@Autowired
	private UserAccountDao userAccountDao;

	@Autowired
	private EnterpriseDao enterpriseDao;
	
	@Autowired
	private WorkRequestDao workRequestDao;
	
	@RequestMapping(value = "/addDrug.htm")
	public ModelAndView adddrug(HttpServletRequest r) {

		HttpSession requestSession = r.getSession();
		UserAccount userAccount = (UserAccount) requestSession.getAttribute("userAccount");

		requestSession.setAttribute("userAccount", userAccount);
		requestSession.setAttribute("enterprise", userAccount.getEnterprise());

		return new ModelAndView("addDrug");
	}
	
	@RequestMapping(value = "/addDrugProcess.htm")
	public ModelAndView addDrug(HttpServletRequest request) {

		Drug drug = new Drug();

		Enterprise enterprise = (Enterprise) request.getSession().getAttribute("enterprise");
		
		int i = Integer.parseInt(request.getParameter("quantity"));
		
		HttpSession requestSession = request.getSession();

		UserAccount userAccount = (UserAccount) requestSession.getAttribute("userAccount");

		requestSession.setAttribute("userAccount", userAccount);
		requestSession.setAttribute("enterprise", userAccount.getEnterprise());
		
		boolean check = drugDao.check(enterprise,request.getParameter("drugname"),i,request.getParameter("expirydate"));
		
		if(check)
		{
			List drugList = drugDao.getDrug(enterprise);
			
			return new ModelAndView("drugDirectory", "drugList", drugList);
		}
		else	{		
		
			drug.setDrugName(request.getParameter("drugname"));
			drug.setEnterprise(enterprise);
			drug.setExpiryDate(request.getParameter("expirydate"));
			drug.setQuantity(i);
	
			drugDao.saveDrug(drug);
	
			List drugList = drugDao.getDrug(enterprise);
	
			return new ModelAndView("drugDirectory", "drugList", drugList);
		}
	}
	
	@RequestMapping(value = "/drugDirectoryManufactured.htm")
	public ModelAndView manufactureDrugDirectory(HttpServletRequest request) {

		Enterprise enterprise = (Enterprise) request.getSession().getAttribute("enterprise");

		HttpSession requestSession = request.getSession();

		List drugList = drugDao.getDrug(enterprise);

		UserAccount userAccount = (UserAccount) requestSession.getAttribute("userAccount");

		requestSession.setAttribute("userAccount", userAccount);
		requestSession.setAttribute("enterprise", userAccount.getEnterprise());

		return new ModelAndView("drugDirectory", "drugList", drugList);

	}
	
	// manufacturer received orders , just redirection
	@RequestMapping(value = "/requestReceived.htm")
	public ModelAndView manufactureRequestReceived(HttpServletRequest request) {
				
		HttpSession requestSession = request.getSession();
		
		Enterprise enterprise = (Enterprise) requestSession.getAttribute("enterprise");		
		List receiverList = workRequestDao.getReceiverRequest(enterprise.getEnterpriseId());

		requestSession.setAttribute("userAccount",
		requestSession.getAttribute("userAccount"));
		requestSession.setAttribute("enterprise", enterprise);

		return new ModelAndView("requestReceived", "slist", receiverList);
	}
	
	//manufacturer responding
	@RequestMapping(value = "/requestProcessManufacturer.htm")
	public ModelAndView manufacturingProcess(HttpServletRequest request) {
		
		Enterprise enterprise = (Enterprise) request.getSession().getAttribute("enterprise");
		request.getSession().setAttribute("userAccount",request.getSession().getAttribute("userAccount"));
		request.getSession().setAttribute("enterprise", enterprise);
		
 		int wrid = Integer.parseInt(request.getParameter("manuwrid"));
 			
 		String drugName = workRequestDao.getDrugName(wrid);
 		
 		if(drugName == "no")
 		{
 			List receiverList = workRequestDao.getReceiverRequest(enterprise.getEnterpriseId());
 			
 			return new ModelAndView("errorPage","slist", receiverList);
 		}
 		
 		int quantity = workRequestDao.getQuantity(wrid);
 		
 		Enterprise senderEnterprise = workRequestDao.getSendere(wrid);
 		
 		boolean check = drugDao.getAva(drugName,quantity,enterprise,senderEnterprise);
 		
 		if(!check)
 		{
 			List receiverList = workRequestDao.getReceiverRequest(enterprise.getEnterpriseId());

 			return new ModelAndView("errorPage","slist", receiverList);
 		}
 		
 		else
 		{
 			workRequestDao.update(wrid);
 			
 			List slist = workRequestDao.getReceiverRequest(enterprise.getEnterpriseId());
	
 			return new ModelAndView("requestReceived", "slist", slist);
 		}
	}

}
