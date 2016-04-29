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
public class DistributersController {
	
	@Autowired
	private DrugsDao drugsDao;
	
	@Autowired
	private EnterprisesDao enterprisesDao;
	
	@Autowired
	private WorkRequestsDao workRequestsDao;
	
	
	@RequestMapping(value = "/distributorPlaceOrder.htm")
	public ModelAndView distributorPlaceOrder(HttpServletRequest request) {

		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");
				
		List manufactureList = enterprisesDao.getEnterprises("Manufacturer", "");

		UserAccounts userAccount = (UserAccounts) session.getAttribute("user");

		session.setAttribute("user", userAccount);
		session.setAttribute("enterp", userAccount.getEnterprise());

		return new ModelAndView("distributorPlaceOrder", "manufactureList", manufactureList);
	}
	
	@RequestMapping(value = "/distributorRequestOrder.htm")
	public ModelAndView distributorRequestOrder(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");

		String name = request.getParameter("drugName");
		String quant = request.getParameter("quantity");
		int quantity = Integer.parseInt(quant);
		String enterp = request.getParameter("man");
		int enterpriseID = Integer.parseInt(enterp);
	
		Enterprises enterprise = enterprisesDao.getEnterprisesById(enterpriseID);

		WorkRequests workRequests = new WorkRequests();

		workRequests.setDrugName(name);
		workRequests.setQuantity(quantity);
		workRequests.setEnterpriseSender((Enterprises) session.getAttribute("enterp"));
		workRequests.setEnterpriseReceiver(enterprise);
		workRequests.setStatus("Sent by Distributor");

		workRequestsDao.saveWorkRequest(workRequests);

		List receiverList = workRequestsDao.getSenderRequests(((Enterprises) session.getAttribute("enterp")).getEnterpriseId());
		session.setAttribute("user", session.getAttribute("user"));
		session.setAttribute("enterp", session.getAttribute("enterp"));
		
		//Sending Mail
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("emailConfig.xml");
		EmailSender emailSender=(EmailSender)context.getBean("emailSenderBean");
		
		UserAccounts userAccount = (UserAccounts)session.getAttribute("user");
		
		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setReceiverEmailAddress(userAccount.geteMail());
		emailMessage.setSubject("Order Successfully Placed");
		//emailMessage.setMessageBody("How you doing");
		emailSender.sendEmail(emailMessage, userAccount, workRequests);

		return new ModelAndView("distributorRequestOrder", "senderList", receiverList);
	}
	
	
	@RequestMapping(value = "/distributorsRequest.htm")
	public ModelAndView distributorsRequest(HttpServletRequest request) {		

		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");
		
		Enterprises enterprise = (Enterprises) request.getSession().getAttribute("enterp");
		
		List<WorkRequests> senderList = workRequestsDao.getSenderRequests(enterprise.getEnterpriseId());
		
		for(WorkRequests r :  senderList) {
			System.out.println(r.getStatus());
		}
		
		session.setAttribute("user", session.getAttribute("user"));
		session.setAttribute("enterp", enterprise);

		return new ModelAndView("distributorRequestOrder", "senderList", senderList);
	}
	
	@RequestMapping(value = "/distributorDrugDirectory.htm")
	public ModelAndView distributorDrugDirectory(HttpServletRequest request) {

		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");
		
		Enterprises enterprise = (Enterprises) request.getSession().getAttribute("enterp");

		List drugsList = drugsDao.getDrugs(enterprise);

		UserAccounts userAccount = (UserAccounts) session.getAttribute("user");

		session.setAttribute("user", userAccount);
		session.setAttribute("enterp", enterprise);

		return new ModelAndView("distributorDrugDirectory", "drugList", drugsList);

	}
	
	
	@RequestMapping(value = "/distributorReceiveOrder.htm")
	public ModelAndView distributorReceiveOrder(HttpServletRequest request) {
				
		System.out.println("Distributor Receive Order");		

		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");
		
		Enterprises enterprise = (Enterprises) request.getSession().getAttribute("enterp");

		List receiverList = workRequestsDao.getReceiverRequests(enterprise.getEnterpriseId());

		session.setAttribute("user", session.getAttribute("user"));
		session.setAttribute("enterp", enterprise);

		return new ModelAndView("distributorReceiveOrder", "senderList", receiverList);
	}
	
	@RequestMapping(value = "/distributorProcess.htm")
	public ModelAndView distributorProcess(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");
		
		Enterprises enterprise = (Enterprises) request.getSession().getAttribute("enterp");
		
		request.getSession().setAttribute("user",request.getSession().getAttribute("user"));
		request.getSession().setAttribute("enterp", enterprise);
		
 		int workRequestID = Integer.parseInt(request.getParameter("distWorkID"));
 		
 		String drug = workRequestsDao.getDrugNames(workRequestID);
 		
 		if(drug == "none")	{
 			
 			List receiverRequest = workRequestsDao.getReceiverRequests(enterprise.getEnterpriseId());
 			return new ModelAndView("distributorErrorPage","senderList", receiverRequest);
 		}
 		
 		int drugQuantity = workRequestsDao.getQuantities(workRequestID);
 		
 		Enterprises senderEnterprise = workRequestsDao.getSenderEnterprise(workRequestID);			 		
 		boolean checkAvailability = drugsDao.getAvailability(drug,drugQuantity,enterprise,senderEnterprise);
 		
 		if(!checkAvailability)	{
 			
 			List receiverRequest = workRequestsDao.getReceiverRequests(enterprise.getEnterpriseId());
 			return new ModelAndView("distributorErrorPage","senderList", receiverRequest);
 		}	
 		else	{
 			workRequestsDao.updateEnteprise(workRequestID);			 			
 			List receiverRequest = workRequestsDao.getReceiverRequests(enterprise.getEnterpriseId());
 			return new ModelAndView("distributorReceiveOrder", "senderList", receiverRequest);
 		}
	}
}
