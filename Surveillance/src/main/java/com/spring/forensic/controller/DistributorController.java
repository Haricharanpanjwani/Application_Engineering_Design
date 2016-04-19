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
import com.spring.forensic.pojo.Enterprise;
import com.spring.forensic.pojo.UserAccount;
import com.spring.forensic.pojo.WorkRequest;


@Controller
public class DistributorController {
	
	@Autowired
	private DrugDao drugDao;
	
	@Autowired
	private UserAccountDao userAccountDao;
	
	@Autowired
	private EnterpriseDao enterpriseDao;
	
	@Autowired
	private WorkRequestDao workRequestDao;
	
	// distributor places order , just redirection
			@RequestMapping(value = "/placeOrderDistributor.htm")
			public ModelAndView distributorplace(HttpServletRequest r) {

				HttpSession requestSession = r.getSession();

			//	EnterpriseDao e = new EnterpriseDao();
				List manList = enterpriseDao.getManufacturer();

				UserAccount u = (UserAccount) requestSession
						.getAttribute("userAccount");

				System.out.println(manList.size());

				requestSession.setAttribute("userAccount", u);
				requestSession.setAttribute("enterprise", u.getEnterprise());

				return new ModelAndView("placeOrderDistributor", "manlist", manList);
			}

			// distributor placing request to manufacturer
			@RequestMapping(value = "/orderRequestDistributor.htm")
			public ModelAndView disorderitem(HttpServletRequest r) {
				HttpSession requestSession = r.getSession();

				String drugName = r.getParameter("drugName");
				String quantity = r.getParameter("quantity");
				int q = Integer.parseInt(quantity);
				String eId = r.getParameter("man");
				int er = Integer.parseInt(eId);

			
				Enterprise e = enterpriseDao.getEnterpriseById(er);

				WorkRequest workRequest = new WorkRequest();
			

				workRequest.setDrugName(drugName);
				workRequest.setQuantity(q);
				workRequest.setEnterpriseSender((Enterprise) requestSession
						.getAttribute("enterprise"));
				workRequest.setEnterpriseReceiver(e);
				workRequest.setStatus("Sent by Distributor");

				workRequestDao.save(workRequest);

				List reList = workRequestDao.getSenderRequest(((Enterprise) requestSession
								.getAttribute("enterprise")).getEnterpriseId());
				requestSession.setAttribute("userAccount",
						requestSession.getAttribute("userAccount"));
				requestSession.setAttribute("enterprise",
						requestSession.getAttribute("enterprise"));

				return new ModelAndView("orderRequestedDistributor", "slist", reList);

			}

			// distributor already requested drugs , just redirection
			@RequestMapping(value = "/distributorRequested.htm")
			public ModelAndView distributorrequested(HttpServletRequest h) {
				Enterprise e = (Enterprise) h.getSession().getAttribute("enterprise");

				HttpSession requestSession = h.getSession();

			//	WorkRequestDao workRequestDao = new WorkRequestDao();

				List slist = workRequestDao.getSenderRequest(e.getEnterpriseId());

				requestSession.setAttribute("userAccount",
						requestSession.getAttribute("userAccount"));
				requestSession.setAttribute("enterprise", e);

				return new ModelAndView("orderRequestedDistributor", "slist", slist);

			}

			// distributor drug directory
			@RequestMapping(value = "/drugDirectoryDistributor.htm")
			public ModelAndView drugdis(HttpServletRequest h) {
				Enterprise e = (Enterprise) h.getSession().getAttribute("enterprise");

				HttpSession requestSession = h.getSession();

			//	DrugDao drugDao = new DrugDao();

				List drugList = drugDao.getDrug(e);

				UserAccount u = (UserAccount) requestSession
						.getAttribute("userAccount");

				requestSession.setAttribute("userAccount", u);
				requestSession.setAttribute("enterprise", e);

				return new ModelAndView("drugDirectoryDistributor", "drugList", drugList);

			}

			// distributor received orders , just redirection
			@RequestMapping(value = "/orderReceiveDistributor.htm")
			public ModelAndView disrtreceive(HttpServletRequest h) {
				Enterprise e = (Enterprise) h.getSession().getAttribute("enterprise");

				HttpSession requestSession = h.getSession();

			//	WorkRequestDao workRequestDao = new WorkRequestDao();

				List slist = workRequestDao.getReceiverRequest(e.getEnterpriseId());

				requestSession.setAttribute("userAccount",
						requestSession.getAttribute("userAccount"));
				requestSession.setAttribute("enterprise", e);

				return new ModelAndView("orderRecieveDistributor", "slist", slist);

			}
			
			//distributor responding
				@RequestMapping(value = "/requestProcessDistributor.htm")
				public ModelAndView distriprocess(HttpServletRequest h) {
					
					Enterprise e = (Enterprise) h.getSession().getAttribute("enterprise");
					h.getSession().setAttribute("userAccount",h.getSession().getAttribute("userAccount"));
					h.getSession().setAttribute("enterprise", e);
					
			 		int wrid = Integer.parseInt(h.getParameter("distriwrid"));
			 		
			 //		WorkRequestDao workRequestDao = new WorkRequestDao();
			 		
			 		String drugName = workRequestDao.getDrugName(wrid);
			 		
			 		if(drugName == "no")
			 		{
			 			List slist = workRequestDao.getReceiverRequest(e.getEnterpriseId());
			 			
			 			return new ModelAndView("errorPage2","slist", slist);
			 		}
			 		int quantity = workRequestDao.getQuantity(wrid);
			 		Enterprise senderenter = workRequestDao.getSendere(wrid);
			 		
			// 		DrugDao drugDao = new DrugDao();
			 		
			 		boolean check = drugDao.getAva(drugName,quantity,e,senderenter);
			 		
			 		if(!check)
			 		{
			 			List slist = workRequestDao.getReceiverRequest(e.getEnterpriseId());

			 			return new ModelAndView("errorPage2","slist", slist);
			 		}
			 		
			 		else
			 		{
			 			workRequestDao.update(wrid);
			 			
			 			List slist = workRequestDao.getReceiverRequest(e.getEnterpriseId());
				
			 			return new ModelAndView("orderRecieveDistributor", "slist", slist);
			 		}
				}

}
