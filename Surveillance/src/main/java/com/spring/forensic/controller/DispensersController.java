package com.spring.forensic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.forensic.dao.DrugsDao;
import com.spring.forensic.dao.EnterprisesDao;
import com.spring.forensic.dao.UserAccountsDao;
import com.spring.forensic.dao.WorkRequestsDao;
import com.spring.forensic.email.EmailMessage;
import com.spring.forensic.email.EmailSender;
import com.spring.forensic.pojo.Enterprises;
import com.spring.forensic.pojo.UserAccounts;
import com.spring.forensic.pojo.WorkRequests;


@Controller
public class DispensersController {
	
	@Autowired
	private DrugsDao drugsDao;
	
	@Autowired
	private EnterprisesDao enterprisesDao;
	
	@Autowired
	private WorkRequestsDao workRequestsDao;
	
	@RequestMapping(value = "/dispenserPlaceOrder.htm")
	public ModelAndView dispenserPlaceOrder(HttpServletRequest request) {

		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");
		
		List dispenserList = enterprisesDao.getEnterprises("Distributor", "");

		UserAccounts userAccount = (UserAccounts) session.getAttribute("user");

		session.setAttribute("user", userAccount);
		session.setAttribute("enterp", userAccount.getEnterprise());

		return new ModelAndView("dispenserPlaceOrder", "dispenserList", dispenserList);
	}

	@RequestMapping(value = "/dispenserOrderRequest.htm")
	public ModelAndView dispenserOrderRequest(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");

		String drug = request.getParameter("drugName");
		String quant = request.getParameter("quantity");
		int quantity = Integer.parseInt(quant);
		String enterp = request.getParameter("dis");
		int enterpriseID = Integer.parseInt(enterp);

		Enterprises enterprise = enterprisesDao.getEnterprisesById(enterpriseID);

		WorkRequests workRequests = new WorkRequests();

		workRequests.setDrugName(drug);
		workRequests.setQuantity(quantity);
		workRequests.setEnterpriseSender((Enterprises) session.getAttribute("enterp"));
		workRequests.setEnterpriseReceiver(enterprise);
		workRequests.setStatus("Sent by Dispenser");

		workRequestsDao.saveWorkRequest(workRequests);

		List senderList = workRequestsDao.getSenderRequests(((Enterprises) session.getAttribute("enterp")).getEnterpriseId());
		session.setAttribute("user", session.getAttribute("user"));
		session.setAttribute("enterp", session.getAttribute("enterp"));
		
		//Sending Mail
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("emailConfig.xml");
		EmailSender emailSender=(EmailSender)context.getBean("emailSenderBean");
		
		UserAccounts userAccount = (UserAccounts)session.getAttribute("user");
		
		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setReceiverEmailAddress(userAccount.geteMail());
		emailMessage.setSubject("Order has been successfully Placed");
		emailSender.sendEmail(emailMessage, userAccount, workRequests);		

		return new ModelAndView("dispenserRequestOrder", "senderList", senderList);
		
	}


	@RequestMapping(value = "/dispenserRequestedDrug.htm")
	public ModelAndView dispenserRequestedDrug(HttpServletRequest request) {		

		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");
		
		Enterprises enterprise = (Enterprises) request.getSession().getAttribute("enterp");

		List senderList = workRequestsDao.getSenderRequests(enterprise.getEnterpriseId());

		session.setAttribute("user", session.getAttribute("user"));
		session.setAttribute("enterp", enterprise);

		return new ModelAndView("dispenserRequestOrder", "senderList", senderList);
	}
	
	@RequestMapping(value = "/dispenserDrugDirectory.htm")
	public ModelAndView dispenserDrugDirectory(HttpServletRequest request) {		

		HttpSession requestSession = request.getSession();
		
		if(requestSession.getAttribute("user") == null)
			return new ModelAndView("login");
		
		Enterprises enterprise = (Enterprises) request.getSession().getAttribute("enterp");

		List drugsList = drugsDao.getDrugs(enterprise);

		UserAccounts userAccount = (UserAccounts) requestSession.getAttribute("user");

		requestSession.setAttribute("user", userAccount);
		requestSession.setAttribute("enterp", enterprise);

		return new ModelAndView("dispenserDrugDirectory", "drugList", drugsList);
	}

}
