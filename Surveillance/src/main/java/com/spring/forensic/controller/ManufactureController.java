package com.spring.forensic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.forensic.dao.DrugsDao;
import com.spring.forensic.dao.WorkRequestsDao;
import com.spring.forensic.pojo.Drugs;
import com.spring.forensic.pojo.Enterprises;
import com.spring.forensic.pojo.UserAccounts;
import com.spring.forensic.pojo.WorkRequests;



@Controller
public class ManufactureController {
	
	@Autowired
	private DrugsDao drugsDao;
	
	@Autowired
	private WorkRequestsDao workRequestsDao;
	
	@RequestMapping(value = "/addDrugs.htm")
	public ModelAndView addDrugs(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");
			
		UserAccounts userAccount = (UserAccounts) session.getAttribute("user");

		session.setAttribute("user", userAccount);		
		session.setAttribute("enterp", userAccount.getEnterprise());

		return new ModelAndView("drugAdded");
	}
	
	@RequestMapping(value = "/drugAddProcess.htm")
	public ModelAndView drugAddProcess(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");

		Drugs newDrug = new Drugs();

		Enterprises enterprise = (Enterprises) request.getSession().getAttribute("enterp");
		
		int quantity = Integer.parseInt(request.getParameter("quantity"));		

		UserAccounts userAccount = (UserAccounts) session.getAttribute("user");

		session.setAttribute("user", userAccount);
		session.setAttribute("enterp", userAccount.getEnterprise());
		
		boolean checkDrug = drugsDao.checkDrug(enterprise,request.getParameter("drugname"),quantity,request.getParameter("expirydate"));
		
		if(checkDrug)
		{
			List<Drugs> drugList = drugsDao.getDrugs(enterprise);
			
			return new ModelAndView("manufacturerDrugDirectory", "drugList", drugList);
		}
		else	{		
		
			newDrug.setDrugName(request.getParameter("drugname"));
			newDrug.setEnterprise(enterprise);
			newDrug.setExpiryDate(request.getParameter("expirydate"));
			newDrug.setQuantity(quantity);
	
			drugsDao.saveDrugs(newDrug);
	
			List<Drugs> drugList = drugsDao.getDrugs(enterprise);
	
			return new ModelAndView("manufacturerDrugDirectory", "drugList", drugList);
		}
	}
	
	@RequestMapping(value = "/manufacturerDrugDirectory.htm")
	public ModelAndView manufacturerDrugDirectory(HttpServletRequest request) {

		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");
		
		Enterprises enterprise = (Enterprises) request.getSession().getAttribute("enterp");		

		List<Drugs> drugsList = drugsDao.getDrugs(enterprise);

		UserAccounts userAccount = (UserAccounts) session.getAttribute("user");

		session.setAttribute("user", userAccount);
		session.setAttribute("enterp", userAccount.getEnterprise());

		return new ModelAndView("manufacturerDrugDirectory", "drugList", drugsList);
	}
	
	@RequestMapping(value = "/manufactureReceivedRequest.htm")
	public ModelAndView manufactureReceivedRequest(HttpServletRequest request) {
				
		System.out.println("Manufacturer Received Request");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");
		
		Enterprises enterprise = (Enterprises) session.getAttribute("enterp");		
		List<WorkRequests> receiverList = workRequestsDao.getReceiverRequests(enterprise.getEnterpriseId());
		
		for(WorkRequests r : receiverList) {
			System.out.println(r.getRequestId() + " " + r.getStatus());
		}
		
		session.setAttribute("user", session.getAttribute("user"));
		session.setAttribute("enterp", enterprise);
		
		return new ModelAndView("manufacturerReceivedRequest", "senderList", receiverList);
	}
	

	@RequestMapping(value = "/manufacturerRequestProcess.htm")
	public ModelAndView manufacturerRequestProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");
		
		Enterprises enterprise = (Enterprises) request.getSession().getAttribute("enterp");
		request.getSession().setAttribute("user",request.getSession().getAttribute("user"));
		request.getSession().setAttribute("enterp", enterprise);
		
 		int workRequestID = Integer.parseInt(request.getParameter("workRequestID"));
 			
 		String drug = workRequestsDao.getDrugNames(workRequestID);
 		
 		if(drug == "none")	{
 			
 			System.out.println("Request ID not found");
 			List receiverList = workRequestsDao.getReceiverRequests(enterprise.getEnterpriseId()); 
 					
 			return new ModelAndView("manufacturerErrorPage","senderList", receiverList);
 		}
 		
 		int quantity = workRequestsDao.getQuantities(workRequestID);
 		
 		Enterprises senderEnterprise = workRequestsDao.getSenderEnterprise(workRequestID);
 		
 		boolean checkAvailability = drugsDao.getAvailability(drug,quantity,enterprise,senderEnterprise);
 		
 		if(!checkAvailability)	{
 			List receiverList = workRequestsDao.getReceiverRequests(enterprise.getEnterpriseId());
 			return new ModelAndView("manufacturerErrorPage","senderList", receiverList);
 		}
 		
 		else	{
 			workRequestsDao.updateEnteprise(workRequestID); 			
 			List receiverList = workRequestsDao.getReceiverRequests(enterprise.getEnterpriseId()); 			
 			return new ModelAndView("manufacturerReceivedRequest", "senderList", receiverList);
 		}
	}
}
