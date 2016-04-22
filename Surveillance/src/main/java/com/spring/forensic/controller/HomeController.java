package com.spring.forensic.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.forensic.dao.DrugDao;
import com.spring.forensic.dao.EnterpriseDao;
import com.spring.forensic.dao.UserAccountDao;
import com.spring.forensic.dao.WorkRequestDao;
import com.spring.forensic.pojo.Drug;
import com.spring.forensic.pojo.Enterprise;
import com.spring.forensic.pojo.UserAccount;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	
	@Autowired
	private DrugDao drugDao;
	
	@Autowired
	private UserAccountDao userAccountDao;
	
	@Autowired
	private EnterpriseDao enterpriseDao;
	
	@Autowired
	private WorkRequestDao workRequestDao;
	
//	@Autowired
//	@Qualifier("userValidator")
//	UserValidator validator;
//	
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "myHome";
	}

	@RequestMapping(value = "/signedIn.htm")
	public String register(HttpServletRequest request) {

	 
		String userName = request.getParameter("userName");

		userName = userName.replaceAll("[^\\dA-Za-z1-9 ]", "").trim();

		String password = request.getParameter("password");

		UserAccount userAccount = null;

		userAccount = userAccountDao.userAuthentication(userName, password);

		if (userAccount == null)
			return "loginFailed";

		String userView = userAccount.getRole();
		Enterprise enterprise = userAccount.getEnterprise();
		
		HttpSession requestSession = request.getSession(true);
		requestSession.setAttribute("userAccount", userAccount);
		requestSession.setAttribute("enterprise", enterprise);
		
		return userView;
	}

	@RequestMapping(value = "/registerSuccess.htm")
	public ModelAndView signIn(HttpServletRequest request) {

		UserAccount userAccount = new UserAccount();
		String userName = request.getParameter("registerUserName");
		String password = request.getParameter("registerPassword");
		String role = request.getParameter("registerRole");
		String userEnterprise = request.getParameter("enterpriseName");
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String eMail=request.getParameter("eMail");

		userName = userName.trim();		
		UserAccount userCheck = userAccountDao.checkUserName(userName);
		
		userEnterprise = userEnterprise.trim();
		Enterprise enterpriseCheck = enterpriseDao.checkEnterpriseByName(userEnterprise);
		
		if ((userCheck != null) || (enterpriseCheck != null)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			session.setAttribute("firstName", fName);
			session.setAttribute("lastName", lName);
			session.setAttribute("address", address);
			
			return new ModelAndView("alreadyExist");
		}

		// setting Enterprise
		Enterprise enterprise = new Enterprise();
		enterprise.setEnterpriseName(userEnterprise);
		enterprise.setRole(role);
		enterpriseDao.saveEnterprise(enterprise);

		// Setting UserAccount
		userAccount.setCity(address);
		userAccount.setFirstName(fName);
		userAccount.setLastName(lName);
		userAccount.setPassword(password);
		userAccount.setRole(role);
		userAccount.setUserName(userName);
		userAccount.setEnterprise(enterprise);
		userAccount.seteMail(eMail);

		if (role.equals("Manufacturer")) {
			userAccount.setLogout("ManufacturerLogout");
			userAccount.setView("Manufacturer");
		} else if (role.equals("Distributor")) {
			userAccount.setLogout("DistributorLogout");
			userAccount.setView("Distributor");
		} else if (role.equals("Dispenser")) {
			userAccount.setLogout("DispenserLogout");
			userAccount.setView("Dispenser");
		}

		userAccountDao.saveUserAccount(userAccount);

		List<UserAccount> userList = userAccountDao.getUserAccount();

		HttpSession requestSession = request.getSession();
		
		UserAccount user = (UserAccount) requestSession.getAttribute("userAccount");

		requestSession.setAttribute("userAccount", user);
		requestSession.setAttribute("enterprise", user.getEnterprise());

		return new ModelAndView("userAdded", "userList", userList);
	}

	@RequestMapping(value = "/addUser.htm")
	public ModelAndView adduser(HttpServletRequest r) {

		HttpSession requestSession = r.getSession();
		UserAccount userAccount = (UserAccount) requestSession.getAttribute("userAccount");

		requestSession.setAttribute("userAccount", userAccount);
		requestSession.setAttribute("enterprise", userAccount.getEnterprise());

		return new ModelAndView("registerUser");
	}

	@RequestMapping(value = "/enterpriseDirectory.htm")
	public ModelAndView enterprisedirectory(HttpServletRequest request) {
		
		HttpSession requestSession = request.getSession();
		
		Enterprise enterprise = (Enterprise) requestSession.getAttribute("enterprise");

		requestSession.setAttribute("userAccount",
		requestSession.getAttribute("userAccount"));
		requestSession.setAttribute("enterprise", enterprise);
		
		String filter = "";		
		List<Enterprise> enterpriseList = enterpriseDao.getEnterprise(filter);
		
		if(request.getParameter("role") != null) {										
				
			if(request.getParameter("filter") != null) {
				filter = request.getParameter("filter");
			}
			System.out.println(filter);	
							
			enterpriseList = enterpriseDao.getEnterprise(filter);
		}				

		return new ModelAndView("enterDirectory", "entlist", enterpriseList);
	}

	@RequestMapping(value = "/userDirectory.htm")
	public ModelAndView userdirectory(HttpServletRequest r) {
		
		System.out.println("In user directory");
		
		HttpSession requestSession = r.getSession();

		UserAccount userAccount = (UserAccount) requestSession.getAttribute("userAccount");
		requestSession.setAttribute("userAccount", userAccount);
		requestSession.setAttribute("enterprise", userAccount.getEnterprise());

		List userList = userAccountDao.getUserAccount();
		return new ModelAndView("userAdded", "userList", userList);
	}
	
	@RequestMapping(value = "/reportGeneration.htm")
	public String reportGeneration() {		
		return "reportGeneration";
	}
	
	@RequestMapping(value = "/reportType.htm")
	public ModelAndView reportGenerationType(HttpServletRequest request) {
		
		HttpSession requestSession = request.getSession();		
		
		String type = request.getParameter("type");		
		System.out.println(type);					
		
		requestSession.setAttribute("userAccount",
		requestSession.getAttribute("userAccount"));		
		
		if(type.equals("drugs")) {
			
			String filter = "asc";
			
			if(request.getParameter("filter") != null) {
				filter = request.getParameter("filter");
			}
			System.out.println(filter);	
			
			List<Drug> drugList = drugDao.getAllDrugs(filter);
			requestSession.setAttribute("drugList", drugList);
			return new ModelAndView("drugReport", "drugList", drugList);
		}
		else if(type.equals("manufacturer")) {
			
//			List manufacturerList = (List) dfghj;
//			return new ModelAndView("generalReport", "manufacturerList", manufacturerList);
		}		
		return null;
	}
	
	@RequestMapping(value = "/logout.htm")
	public ModelAndView logout(HttpServletRequest request)	{
		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("myHome");
	}
	
	@RequestMapping(value="/givedrug.htm")
	@ResponseBody String getCompanyData(HttpServletRequest request,HttpServletResponse response) throws Exception	{
		response.setHeader("Pragma", "No-cache");
	    response.setDateHeader("Expires", 0);
	    response.setHeader("Cache-Control", "no-cache");
		
		StringBuilder responseText = new StringBuilder();
		int eid = Integer.parseInt(request.getParameter("comp"));
		
		Enterprise e = enterpriseDao.getEnterpriseById(eid);
		List requestData = drugDao.getDrug(e);
	
		for(Object obj : requestData){
			 Drug drug = (Drug) obj;
			 responseText.append("<option value=" + drug.getDrugName()+ ">" + drug.getDrugName() + "</option>");
		 }
		
		System.out.println("final data: " + responseText);
		
		return responseText.toString();
	}
	
	// Generating Report 
	@RequestMapping(value="/generateReport.htm")
	public ModelAndView reportman(HttpServletRequest r)	{
			
		Enterprise e = (Enterprise)r.getSession().getAttribute("enterprise");
		List drugList = drugDao.getDrug(e);
			
		return new ModelAndView("PdfView","drugList",drugList);
	}
}
