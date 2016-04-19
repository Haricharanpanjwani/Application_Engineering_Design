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
public class DispenserController {
	
	@Autowired
	private DrugDao drugDao;
	
	@Autowired
	private UserAccountDao userAccountDao;
	
	@Autowired
	private EnterpriseDao enterpriseDao;
	
	@Autowired
	private WorkRequestDao workRequestDao;
	
			@RequestMapping(value = "/placeOrderDispenser.htm")
			public ModelAndView dispenserplace(HttpServletRequest r) {

				HttpSession requestSession = r.getSession();

			//	EnterpriseDao e = new EnterpriseDao();
				List disList = enterpriseDao.getDistributor();

				UserAccount u = (UserAccount) requestSession
						.getAttribute("userAccount");

				System.out.println(disList.size());

				requestSession.setAttribute("userAccount", u);
				requestSession.setAttribute("enterprise", u.getEnterprise());

				return new ModelAndView("placeOrderDispenser", "dislist", disList);
			}

			// dispenser placing request to distributor
			@RequestMapping(value = "/orderRequestDispenser.htm")
			public ModelAndView disporderitem(HttpServletRequest r) {
				HttpSession requestSession = r.getSession();

				String drugName = r.getParameter("drugName");
				String quantity = r.getParameter("quantity");
				int q = Integer.parseInt(quantity);
				String eId = r.getParameter("dis");
				int er = Integer.parseInt(eId);

			//	EnterpriseDao enterpriseDao = new EnterpriseDao();
				Enterprise e = enterpriseDao.getEnterpriseById(er);

				WorkRequest workRequest = new WorkRequest();
			//	WorkRequestDao workRequestDao = new WorkRequestDao();

				workRequest.setDrugName(drugName);
				workRequest.setQuantity(q);
				workRequest.setEnterpriseSender((Enterprise) requestSession
						.getAttribute("enterprise"));
				workRequest.setEnterpriseReceiver(e);
				workRequest.setStatus("Sent by Dispenser");

				workRequestDao.save(workRequest);

				List reList = workRequestDao.getSenderRequest(((Enterprise) requestSession
								.getAttribute("enterprise")).getEnterpriseId());
				requestSession.setAttribute("userAccount",
						requestSession.getAttribute("userAccount"));
				requestSession.setAttribute("enterprise",
						requestSession.getAttribute("enterprise"));

				return new ModelAndView("orderRequestDispenser", "slist", reList);

			}

			// dispenser already requested drugs , just redirection
			@RequestMapping(value = "/dispenserRequested.htm")
			public ModelAndView dispenserrequested(HttpServletRequest h) {
				Enterprise e = (Enterprise) h.getSession().getAttribute("enterprise");

				HttpSession requestSession = h.getSession();

			//	WorkRequestDao workRequestDao = new WorkRequestDao();

				List slist = workRequestDao.getSenderRequest(e.getEnterpriseId());

				requestSession.setAttribute("userAccount",
						requestSession.getAttribute("userAccount"));
				requestSession.setAttribute("enterprise", e);

				return new ModelAndView("orderRequestDispenser", "slist", slist);

			}

			// dispenser drug directory
			@RequestMapping(value = "/drugDirectoryDispenser.htm")
			public ModelAndView drugdisp(HttpServletRequest h) {
				Enterprise e = (Enterprise) h.getSession().getAttribute("enterprise");

				HttpSession requestSession = h.getSession();

			//	DrugDao drugDao = new DrugDao();

				List drugList = drugDao.getDrug(e);

				UserAccount u = (UserAccount) requestSession
						.getAttribute("userAccount");

				requestSession.setAttribute("userAccount", u);
				requestSession.setAttribute("enterprise", e);

				return new ModelAndView("drugDirectoryDispenser", "drugList", drugList);

			}

}
