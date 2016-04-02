/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part4;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hpanjwani
 */
public class InsuranceQuestionnaire extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsuranceQuestionnaire</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsuranceQuestionnaire at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<?xml version='1.0' ?>");
		out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Pet Health Insurance Form</title>");
		out.println("<meta name='viewpoint' content='width=device-width,initial-scale=1'>");
                
                out.println("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js\"></script>");
                out.println("<script type='text/javascript'>");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javascript/validation.js");
                dispatcher.include(request, response);
                out.println("</script>"); 
		//<!--Including BootStrap -->		
		out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>");
		out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>");
		out.println("</head>");
		out.println("<body>");
                                
			out.println("<form role='form' id='insuranceForm' action='insuranceForm.htm' method='POST' onsubmit=\"return validateForm()\">");

					//<!--Heading -->
				out.println("<div class='bg-primary text-center'>");
					out.println("<h3>ASPCA PET HEALTH INSURANCE</h3>");
									
				out.println("</div>");

				out.println("<div class='container'>");

					//<!--General Information -->
					out.println("<div class='container contact_tot'>");
					    out.println("<div class='panel panel-default'>");
					       out.println("<div class='panel-heading'>");			       
					        	out.println("<label>CLAIM FORM </label>&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<i><label>PLEASE INCLUDE YOUR PET'S MEDICAL RECORD TO HELP EXPEDITE PROCESSING</label></i>");
					      out.println("</div>");			      
					    out.println("</div>");
					out.println("</div>");

					//<!--General Information -->
					out.println("<div class='container contact_tot'>");
					    out.println("<div class='panel panel-default'>");
					       out.println("<div class='panel-heading'>");			       
					         out.println("<b>General Information</b> &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp <i><small>Please fill out this form completely. Incomplete forms will delay processing.</small></i>");
					      out.println("</div>");			      
					    out.println("</div>");
					out.println("</div>");
						
					//<!--Personal Information -->
					out.println("<div class='form-group col-sm-6'>");
						
						out.println("<div class='panel panel-default'>");
						   out.println("<div class='panel-heading'>");			       
						      out.println("<b>Personal Information</b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp<i><small><label class='checkbox-inline'><input type='checkbox' id='New Address' name='New Address?' value='Yes'>Check here if this is a new address</label></small></i>");
						    out.println("</div>");			      
					   	out.println("</div>");
										
						out.println("<div class='form-group col-sm-6'>");
						out.println("<label>Name:</label><input type='text' id='Name' name='Name' Placeholder='First &amp Last Name' class='form-control'  />");				
                                                out.println("<span></span>");
						out.println("</div>");
						out.println("<div class='form-group col-sm-6'>");
						out.println("<label>Address:</label><input type='text' id='Address' name='Address' Placeholder='Address' class='form-control' />");					
						out.println("</div>");	
						out.println("<div class='form-group col-sm-6'>");
						out.println("<label>City:</label><input type='text' id='City' name='City' Placeholder='City' class='form-control' />");			
						out.println("</div>");	
						out.println("<div class='form-group col-sm-6'>");
						out.println("<label>State:</label><input type='text' id='State' name='State' Placeholder='State' class='form-control' />");				
						out.println("</div>");	
						out.println("<div class='form-group col-sm-6'>");
						out.println("<label>Zip Code:</label><input type='text' id='Zip Code' name='Zip Code' Placeholder='Zip Code' class='form-control' />");				
						out.println("</div>");	
						out.println("<div class='form-group col-sm-6'>");
						out.println("<label>Phone Number:</label><input type='text' id='Contact Number' name='Contact Number' Placeholder='(999)-999-9999' class='form-control' />");								
						out.println("</div>");	
						out.println("<div class='form-group col-sm-12'>");
						out.println("<label>Email ID:</label><input type='text' id='Email ID' name='Email ID' Placeholder='abc@yahoo.com' class='form-control' />");			
						out.println("</div>");	
					out.println("</div>");

					//<!--Pet Information -->
					out.println("<div class='form-group col-sm-6'>");

						out.println("<div class='panel panel-default'>");
						   out.println("<div class='panel-heading'>");			       
						      out.println("<b>Pet Information</b>");
						    out.println("</div>");			      
					   	out.println("</div>");
						
						out.println("<div class='form-group col-sm-6'>");
						out.println("<label>Account Number:</label><input type='text' id='Account Number' name='Account Number' Placeholder='999-999-8888' class='form-control' />");
						out.println("</div>");
						out.println("<div class='form-group col-sm-6'>");
						out.println("<label>Name:</label><input type='text' id='Pet Name' name='Pet Name' Placeholder='Name of Pet' class='form-control' />");			
						out.println("</div>");	
						out.println("<div class='form-group col-sm-6'>");
						out.println("<label>Breed:</label><input type='text' id='Breed' name='Breed' Placeholder='Breed of Pet' class='form-control' />");				
						out.println("</div>");	
						out.println("<div class='form-group col-sm-6'>");
						out.println("<label>Age:</label><input type='text' id='Age' name='Age' Placeholder='Age' class='form-control' />");				
						out.println("</div>");	
						out.println("<div class='form-group col-sm-12'></div>");
						out.println("<div class='form-group col-sm-12'></div>");
						out.println("<div class='form-group col-sm-3'>");
						out.println("<label>Gender:</label>");
						out.println("</div>");
						out.println("<div class='form-group col-sm-6'>");
						out.println("<p><label class='radio-inline'><input type='radio' name='Gender' value='Male' checked> Male </label>");
						out.println("<label class='radio-inline'><input type='radio' name='Gender' value='Female'>Female</label></p>");				
						out.println("</div>");	
					out.println("</div>");	

					//<!--Diagnosis/Symptom Information -->
					out.println("<div class='form-group col-sm-12'>");
						
						out.println("<div class='panel panel-default'>");
						   out.println("<div class='panel-heading'>");			       
						      out.println("<b>Diagnosis / System Information</b>");
						    out.println("</div>");			      
					   	out.println("</div>");

					   	out.println("<label>Story of Occurence / Diagnosis</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<b><i><small>-Please describe this incident, including dates, details and symptons leading upto it.</small></i></b>");		

						out.println("<textarea class='form-control' Placeholder='Brief disctiption of incident or any history of the condition' rows='5' id='Diagnosis' name='Diagnosis'></textarea><br />");

						out.println("<div class='form-group col-sm-6'>");
						out.println("<p><label>This claim is related to:</label></p>");
					out.println("<label class='radio-inline'><input type='radio' name='Claim Related To' value='Accident' checked>Accident</label>");
					out.println("<label class='radio-inline'><input type='radio' name='Claim Related To' value='Illness'>Illness</label>");
					out.println("<label class='radio-inline'><input type='radio' name='Claim Related To' value='Wellness'>Wellness</label>");
					out.println("<br />");
					out.println("<br />");

					out.println("<p><label>Is this claim an estimate for future treatment?</label></p>");
					out.println("<label class='radio-inline'><input type='radio' name='Claim Estimate for Future?' value='Yes' checked>Yes</label>");
					out.println("<label class='radio-inline'><input type='radio' name='Claim Estimate for Future?' value='No'>No</label>");
					out.println("<br />");
					out.println("<br />");

					out.println("<label>Total amount claimed:</label><input type='text' id='Amount Claimed' name='Amount Claimed' Placeholder='Amount Claim' class='form-control' />");		
					out.println("<br />");

					out.println("<label>Date Illness/Injury first occurred:</label><input type='date' id='Date Illness' name='Date Illness' class='form-control' />");	
					out.println("<br />");

					out.println("<p><label>Send Payment To:</label></p>");
					out.println("<label class='radio-inline'><input type='radio' name='Send Payment to' value='Me' checked>Me</label>");
					out.println("<label class='radio-inline'><input type='radio' name='Send Payment to' value='Veterinarian'>Veterinarian</label>");
					out.println("<br />");
					out.println("<br />");
						
					out.println("<p><label>Is this a new condition:</label></p>");
					out.println("<label class='radio-inline'><input type='radio' name='New Condition?' value='Yes' checked>Yes</label>");
					out.println("<label class='radio-inline'><input type='radio' name='New Condition?' value='No'>No</label>");					
					out.println("<br />");
				out.println("</div>");

				out.println("<div class='form-group col-sm-6'>");
					out.println("<label>Veterinarian:</label><input type='text' id='Veterinarian' name='Veterinarian' Placeholder='Veterinarian' class='form-control' />");	
					out.println("<br />");

					out.println("<label>Clinic Name:</label><input type='text' id='Clinic Name' name='Clinic Name' Placeholder='Name of Clinic' class='form-control' />");
					out.println("<br />");

					out.println("<label>Phone Number:</label><input type='text' id='Phone Number' name='Phone Number' Placeholder='(999)-999-9999' class='form-control' />");	
					out.println("<br />");

					out.println("<label>Fax Number:</label><input type='text' id='Fax Number' name='Fax Number' Placeholder='(999)-999-9999' class='form-control' />");
					out.println("<br />");

					out.println("<p><label>Did any other veterinarian treat your pet:</label></p>");
					out.println("<label class='radio-inline'><input type='radio' name='Any other Veterinarian treated?' value='Yes' checked>Yes</label>");
					out.println("<label class='radio-inline'><input type='radio' name='Any other Veterinarian treated?' value='No'>No</label>");	
					out.println("<br />");


				out.println("</div>");

						
					out.println("</div>");
						
					//<!--Pet Owner Declaration -->
					out.println("<div class='form-group col-sm-12'>");

						out.println("<div class='panel panel-default'>");
						   out.println("<div class='panel-heading'>");			       
						    	out.println("<b>Pet Owner Declaration</b>");
							out.println("</div>");			      
						out.println("</div>");
							
						out.println("<label><input type='checkbox' id='Agreement' name='Agreement' value='Yes'>&nbsp&nbsp&nbsp<b>I confirm to the best of my knowledge the above statements are true in every respect. I understand that the fees listed may not be covered or may exceed my plan benefit. I understand that I am financially responsible to my veterinarian for the entire treatment. I understand that this claim cannot be adjusted without itemized receipts. I also understand that the deliberate misrepresentation of the animal”s condition or the omission of any material facts may result in the denial of the claim and/or the cancellation of coverage. I authorize United States Fire Insurance Company and its business partners to review and obtain a copy of ALL RECORDS including the insurance claim records and medical records as to examination, history, diagnosis, treatment and prognosis with respect to any condition. I further authorize these entities to disclose identifying information about me and my pet, as well as information about my claim experience, to my veterinarian.</b></label>");
						
					out.println("</div>");

					out.println("<div class='form-group col-sm-12'>");
						
						out.println("<div class='form-group col-sm-9'>");
		  				out.println("<label>Signature of Pet Owner:</label><input type='text' Placeholder='Full Name of Pet Owner' id='Signature' name='Signature' class='form-control' />");
		  				out.println("</div>");

						out.println("<div class='form-group col-sm-3'>");
		  				out.println("<label>Date:</label><input type='date' id='Date' name='Date' class='form-control' />");
						out.println("</div>");
					
						out.println("<div class='form-group col-sm-12'>");
						out.println("<button type='submit' name='submit' class='btn btn-primary btn-md'>SUBMIT</button>");
						out.println("</div>");
						out.println("<hr />");

						out.println("<div class='bg-danger text-center col-sm-12'>");
						out.println("<h5>Please read IMPORTANT NOTICE document that follows for additional information</h3>");
						out.println("</div>");
					out.println("</div>");

				out.println("</div>");
			out.println("</form>");		

			out.println("</body>");
		out.println("</html>");
		out.close();	

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
                response.setContentType("text/html");
		PrintWriter out = response.getWriter();                
                
                //Sanitization on Server Side
                String name = request.getParameter("Name");
                name = name.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
                String address = request.getParameter("Address");
                address = address.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
                String city = request.getParameter("City");
                city = city.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
                String state = request.getParameter("State");
                state = state.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
                String zipcode = request.getParameter("Zip Code");
                zipcode = zipcode.replaceAll("[^\\d]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
                String contactNumber = request.getParameter("Contact Number");
                contactNumber = contactNumber.replaceAll("[^\\d]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
                String emailID = request.getParameter("Email ID");
                emailID = emailID.replaceAll("[^\\dA-Za-z@. ]", "").replaceAll("\\s+", "+").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
                String accountNumber = request.getParameter("Account Number");
                accountNumber = accountNumber.replaceAll("[^\\d]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
                String petName = request.getParameter("Pet Name");
                petName = petName.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","*").trim();
                
                String breed = request.getParameter("Breed");
                breed = breed.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
                String age = request.getParameter("Age");
                age = age.replaceAll("[^\\d]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
                String diagnosis = request.getParameter("Diagnosis");                                    
                diagnosis = diagnosis.replaceAll("[^\\dA-Za-z@. ]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
                String amountClaimed = request.getParameter("Amount Claimed");
                amountClaimed = amountClaimed.replaceAll("[^\\d]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
                String phoneNumber = request.getParameter("Phone Number");
                phoneNumber = phoneNumber.replaceAll("[^\\d]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
                String faxNumber = request.getParameter("Fax Number");
                faxNumber = faxNumber.replaceAll("[^\\d]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
                String veterinarian = request.getParameter("Veterinarian");
                veterinarian = veterinarian.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
                String clinicName = request.getParameter("Clinic Name");
                clinicName = clinicName.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
                String sign = request.getParameter("Signature");
                sign = sign.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").replaceAll("<","+").replaceAll(">","+").trim();
                
		out.println("<html>");
		out.println("<head>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
  		out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>");
  		out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script>");
  		out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>");
  		out.println("<style type='text/css'>");
   		out.println("body { background: #e3f2fd; !important; }");
		out.println("</style>");
		out.println("<title>Insurance Form</title>");
		out.println("</head>");
		out.println("<body>");
		
		//out.println("<div class='well'>");
		out.println("<center><label>Thank you for submitting the form</label></center>");
		out.println("<center><label>Your request will be processed shortly</label></center>");
		out.println("<hr />");
		//out.println("</div>");

		//getHeaderNames
		out.println("<div class='container'>");
  
  		out.println("<table border='1' width=100% class='table table-hover'>");
	    	out.println("<thead>");
	      	out.println("<tr>");
	        out.println("<th>Field Name</th>");
	        out.println("<th>Details</th>");
	      	out.println("</tr>");
	    	out.println("</thead>");
    		out.println("<tbody>");

    		out.println("<tr>");
    			out.println("<td>Name: </td>");
    			out.println("<td>" + name + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Address: </td>");
    			out.println("<td>" + address + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>City: </td>");
    			out.println("<td>" + city + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>State: </td>");
    			out.println("<td>" + state + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Zip Code: </td>");
    			out.println("<td>"+ zipcode + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Contact Number: </td>");
    			out.println("<td>" + contactNumber + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Email ID: </td>");
    			out.println("<td>" + emailID + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Account Number: </td>");
    			out.println("<td>" + accountNumber + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Pet Name: </td>");
    			out.println("<td>" + petName + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Breed: </td>");
    			out.println("<td>" + breed + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Age: </td>");
    			out.println("<td>" + age + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Gender: </td>");
    			out.println("<td>" + request.getParameter("Gender") + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Diagnosis: </td>");
    			out.println("<td>" + diagnosis + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>This claim is related to: </td>");
    			out.println("<td>" + request.getParameter("Claim Related To") + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Is Claim Estimate for Future?:</td>");
    			out.println("<td>" + request.getParameter("Claim Estimate for Future?") + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Total Amount claimed: </td>");
    			out.println("<td>" + amountClaimed + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Date Illness: </td>");
    			out.println("<td>" + request.getParameter("Date Illness") + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Send Payment to: </td>");
    			out.println("<td>" + request.getParameter("Send Payment to") + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Veterinarian: </td>");
    			out.println("<td>" + veterinarian + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Clinic Name: </td>");
    			out.println("<td>" + clinicName + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Phone Number: </td>");
    			out.println("<td>" + phoneNumber + "</td>");
    		out.println("</tr>");
			out.println("<tr>");
    			out.println("<td>Fax Number: </td>");
    			out.println("<td>" + faxNumber + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Did any other veterinarian treat your pet?: </td>");
    			out.println("<td>" + request.getParameter("Any other Veterinarian treated?") + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Is this a new condition: </td>");
    			out.println("<td>" + request.getParameter("New Condition?") + "</td>");
    		out.println("</tr>");
                out.println("<tr>");
                    out.println("<td>Agreement: </td>");
                    out.println("<td>" + request.getParameter("Agreement") + "</td>");
                out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Signature: </td>");
    			out.println("<td>" + sign + "</td>");
    		out.println("</tr>");
    		out.println("<tr>");
    			out.println("<td>Date: </td>");
    			out.println("<td>" + request.getParameter("Date") + "</td>");
    		out.println("</tr>");

			out.println("</tbody");	
                    out.println("</table>");
		out.println("</div>");	
		
		out.println("</body>");
		out.println("</html>");
		out.close();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
