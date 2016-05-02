package com.spring.forensic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.forensic.dao.DrugsDao;
import com.spring.forensic.dao.EnterprisesDao;
import com.spring.forensic.dao.UserAccountsDao;
import com.spring.forensic.dao.WorkRequestsDao;
import com.spring.forensic.email.EmailMessage;
import com.spring.forensic.email.EmailSender;
import com.spring.forensic.pojo.Drugs;
import com.spring.forensic.pojo.Enterprises;
import com.spring.forensic.pojo.UserAccounts;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	@Autowired
	private DrugsDao drugsDao;
	
	@Autowired
	private UserAccountsDao userAccountsDao;
	
	@Autowired
	private EnterprisesDao enterprisesDao;
	
	@Autowired
	private WorkRequestsDao workRequestsDao;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "login";
	}
	
	//@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	@RequestMapping(value = "/admin/login.htm", method = RequestMethod.GET)
	public String privatePag(HttpServletRequest request) {
		System.out.println("get home page");
		
		String name = "admin";
		String password = "admin";

		UserAccounts userAccount = null;
		Enterprises enterprise = null;
		
		userAccount = userAccountsDao.usersAuthentication(name, password);

		if (userAccount == null) {
			
			System.out.println("Creating User");
			
			userAccount = new UserAccounts();
			userAccount.setFirstName("Hari");
			userAccount.setLastName("Panjwani");
			userAccount.setCity("Boston");
			userAccount.setUserName("admin");
			userAccount.setPassword("admin");
			userAccount.seteMail("admin@gmail.com");
			userAccount.setRole("Admin");
			
			enterprise = new Enterprises();
			enterprise.setEnterpriseName("Surveillance App");
			enterprise.setRole("Admin");
			enterprisesDao.saveEnterprises(enterprise);
			
			userAccount.setEnterprise(enterprise);
			userAccountsDao.saveUserAccounts(userAccount);
			
		}
		else {
			
			System.out.println("Admin Exist");
			enterprise = userAccount.getEnterprise();
			System.out.println("Enterprise : " + enterprise.getEnterpriseName());
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("user", userAccount);
		session.setAttribute("enterp", enterprise);
		
		return "Admin";
	}

	@RequestMapping(value = "/signIn.htm")
	public String userSignedIn(HttpServletRequest req) {
		
		if(req.getParameter("userName") == null)
			return "login";

		String name = req.getParameter("userName");

		name = name.replaceAll("[^\\dA-Za-z1-9 ]", "").trim();

		String password = req.getParameter("password");

		UserAccounts userAccount = null;

		userAccount = userAccountsDao.usersAuthentication(name, password);

		if (userAccount == null)
			return "loginFail";

		String userView = userAccount.getRole();
		Enterprises enterprise = userAccount.getEnterprise();
		
		HttpSession session = req.getSession(true);
		session.setAttribute("user", userAccount);
		session.setAttribute("enterp", enterprise);
		
		return userView;
	}
	
	//@RequestMapping(value = "/registerationSuccess.htm")
	@RequestMapping(value = "/admin/registerationSuccess.htm")
	public ModelAndView registerUserAccount(HttpServletRequest req) {

		UserAccounts userAcc = new UserAccounts();
		String name = req.getParameter("userName");
		String pasword = req.getParameter("password");
		String role = req.getParameter("role");
		String enterpriseName = req.getParameter("enterpriseName");
		String firstName = req.getParameter("fName");
		String lastName = req.getParameter("lName");
		String address = req.getParameter("address");
		String email = req.getParameter("email");

		name = name.trim();		
		UserAccounts userCheck = userAccountsDao.verifyUserName(name, email);
		
		enterpriseName = enterpriseName.trim();
		Enterprises enterpriseCheck = enterprisesDao.checkEnterprisesByName(enterpriseName);		
		
		if ((userCheck != null) || (enterpriseCheck != null)) {
			
			System.out.println("User exist");
						
			HttpSession session = req.getSession();
			session.setAttribute("userName", name);
			session.setAttribute("firstName", firstName);
			session.setAttribute("lastName", lastName);
			session.setAttribute("address", address);
			
			return new ModelAndView("userExist");
		}
		
		System.out.println("User not found!! Creating new user");
		
		Enterprises enterprise = new Enterprises();
		enterprise.setEnterpriseName(enterpriseName);
		enterprise.setRole(role);
		enterprisesDao.saveEnterprises(enterprise);

		userAcc.setCity(address);
		userAcc.setFirstName(firstName);
		userAcc.setLastName(lastName);
		userAcc.setPassword(pasword);
		userAcc.setRole(role);
		userAcc.setUserName(name);
		userAcc.setEnterprise(enterprise);
		userAcc.seteMail(email);

		userAccountsDao.saveUserAccounts(userAcc);
		
		List<UserAccounts> userList = userAccountsDao.getUserAccounts();

		HttpSession session = req.getSession();
		
		UserAccounts user = (UserAccounts) session.getAttribute("user");
		session.setAttribute("user", user);
		session.setAttribute("enterp", user.getEnterprise());

		return new ModelAndView("userAccountAdded", "userList", userList);
	}

	//@RequestMapping(value = "/userAdded.htm")
	@RequestMapping(value = "/admin/userAdded.htm")
	public ModelAndView addUserAccount(HttpServletRequest request) {

		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");
		
		UserAccounts userAccount = (UserAccounts) session.getAttribute("user");

		session.setAttribute("user", userAccount);
		session.setAttribute("enterp", userAccount.getEnterprise());

		return new ModelAndView("registerUserAccount");
	}
	
	//@RequestMapping(value = "/enterprisesDirectory.htm")
	@RequestMapping(value = "/admin/enterprisesDirectory.htm")
	public ModelAndView enterpriseDirectoryList(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");
		
		Enterprises enterprise = (Enterprises) session.getAttribute("enterp");

		session.setAttribute("user", session.getAttribute("user"));
		session.setAttribute("enterp", enterprise);
		
		String filter = "";
		String search = "";
		
		List<Enterprises> enterpriseList = enterprisesDao.getEnterprises(filter, search);
		
		if(request.getParameter("role") != null) {										
				
			if(request.getParameter("filter") != null) {
				filter = request.getParameter("filter");
			}
			System.out.println(filter);
			
			if(request.getParameter("search") != null) {
				search = request.getParameter("search");
			}
							
			enterpriseList = enterprisesDao.getEnterprises(filter, search);
		}				

		return new ModelAndView("enterprisesDirectory", "enterpriseList", enterpriseList);
	}
	
	@RequestMapping(value = "/search.htm")
	public ModelAndView userSearch(HttpServletRequest request) {
		
//		HttpSession session = request.getSession();
//
//		UserAccounts userAccount = (UserAccounts) session.getAttribute("user");
//		session.setAttribute("user", userAccount); 
//		session.setAttribute("enterp", userAccount.getEnterprise());
//		
//		/*Hibernate Searching */		
//		String searchString = request.getParameter("search");
//	
//		userAccountsDao.doIndex();
//		List<UserAccounts> userList = userAccountsDao.search(searchString);
//		
//		for(UserAccounts user : userList)
//			System.out.println(user);
//		
//		session.setAttribute("userList", userList);
		drugsDao.getAllDrugs("asc");
		return null;
	}

	//@RequestMapping(value = "/usersDirectory.htm")
	@RequestMapping(value = "/admin/usersDirectory.htm")
	public ModelAndView userDirectoryList(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");
		
		UserAccounts userAccount = (UserAccounts) session.getAttribute("user");
		session.setAttribute("user", userAccount);
		session.setAttribute("enterp", userAccount.getEnterprise());	
		
		List userList = null;
		
		userAccountsDao.doIndex();
		
		/*Hibernate Searching */
		if(request.getParameter("search") != null) {
					
			String searchString = request.getParameter("search");			
			userList = userAccountsDao.search(searchString);			
		}	
		else { 
			userList = userAccountsDao.getUserAccounts();
		}
		
		if(request.getParameter("reset") != null ) {
			System.out.println("Reset");
			userList = userAccountsDao.getUserAccounts();
		}
		
		session.setAttribute("userList", userList);
		
		return new ModelAndView("userAccountAdded", "userList", userList);
	}
	
	//@RequestMapping(value = "/reportGeneration.htm")
	@RequestMapping(value = "/admin/reportGeneration.htm")
	public ModelAndView reportGenerationType(HttpServletRequest request) {
		
		HttpSession session = request.getSession();		
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");
		
		UserAccounts userAccount = (UserAccounts) session.getAttribute("user");
		session.setAttribute("user", session.getAttribute("user"));
		session.setAttribute("enterp", userAccount.getEnterprise());
		
		List reportList = workRequestsDao.reportGenerate();		

		System.out.println("report: " + reportList.size());
		
		return new ModelAndView("reportGeneration", "reportList", reportList);
	}
	
	//@RequestMapping(value = "/drugReport.htm")
	@RequestMapping(value = "/admin/drugReport.htm")
	public ModelAndView drugReport(HttpServletRequest request) {
		
		HttpSession requestSession = request.getSession(false);		
		
		if(requestSession.getAttribute("user") == null)
			return new ModelAndView("login");
		
		requestSession.setAttribute("user", requestSession.getAttribute("user"));		
			
		String filter = "asc";
		int min = 0;
		int max = 9999999;
		
		if(request.getParameter("min") != null && request.getParameter("min") != "")
			min = Integer.parseInt((request.getParameter("min")));			
		
		if(request.getParameter("max") != null && request.getParameter("max") != "")
			max = Integer.parseInt((request.getParameter("max")));
			
		if(request.getParameter("filter") != null)
			filter = request.getParameter("filter");
		System.out.println(min + " " + max + " " + " " + filter );
		
		//List<Drugs> drugList = drugsDao.getAllDrugs(filter);
		List<Drugs> drugList = drugsDao.getDrugWithinRange(min, max, filter);
		requestSession.setAttribute("drugList", drugList);
		return new ModelAndView("drugReport", "drugList", drugList);
	}
	
	@RequestMapping(value = "/admin/logout.htm")
	public ModelAndView adminLogout(HttpServletRequest req)	{
		return new ModelAndView("redirect:/logout.htm");
	}

	@RequestMapping(value = "/logout.htm")
	public ModelAndView logout(HttpServletRequest req)	{
		HttpSession requestSession = req.getSession();
		requestSession.invalidate();
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/giveEnterpriseDrug.htm")
	@ResponseBody String getEnterpriseData(HttpServletRequest req,HttpServletResponse resp) throws Exception	{
		
		resp.setHeader("Pragma", "No-cache");
	    resp.setDateHeader("Expires", 0);
	    resp.setHeader("Cache-Control", "no-cache");
		
		StringBuilder responseText = new StringBuilder();
		int enterpriseID = Integer.parseInt(req.getParameter("enterpriseID"));
		
		Enterprises e = enterprisesDao.getEnterprisesById(enterpriseID);
		List<Drugs> requestData = drugsDao.getDrugs(e);
	
		for(Object obj : requestData){
			 Drugs drug = (Drugs) obj;
			 responseText.append("<option value=" + drug.getDrugName()+ ">" + drug.getDrugName() + "</option>");
		 }
		
		System.out.println("final data: " + responseText);
		
		return responseText.toString();
	}
	
	// PDF Report Generation
	@RequestMapping(value="/generatePDFReport.htm")
	public ModelAndView generatePDFReport(HttpServletRequest request)	{
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null)
			return new ModelAndView("login");
		
		Enterprises enterprise = (Enterprises)request.getSession().getAttribute("enterp");
		List<Drugs> drugsList = drugsDao.getDrugs(enterprise);
			
		return new ModelAndView("PdfView","drugList",drugsList);
	}
	
		@RequestMapping(value="/admin/sendMail.htm")
		public ModelAndView sendMail(HttpServletRequest r)	{
					
			  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("emailConfig.xml");
			  EmailSender emailSender=(EmailSender)context.getBean("emailSenderBean");
			  
			  EmailMessage emailMessage = new EmailMessage();
			  emailMessage.setReceiverEmailAddress("");
			  emailMessage.setSubject("Hello");
			  emailMessage.setMessageBody("How you doing");
			  //emailSender.sendEmail(emailMessage);

			return new ModelAndView("login");
		}
}
