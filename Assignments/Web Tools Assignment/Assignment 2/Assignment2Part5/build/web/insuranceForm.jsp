<%-- 
    Document   : insuranceDetails
    Created on : Feb 1, 2016, 9:00:35 PM
    Author     : hpanjwani
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pet Health Insurance Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">   
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <!--Including BootStrap -->        
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">        
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>        
    </head>
    <body>
     
        <div id= "quest" class="insurance">
            <form role="form" action="insuranceForm.jsp" method="POST">

        <!--Heading -->
		<div class="bg-primary text-center">
			<h3>ASPCA PET HEALTH INSURANCE</h3>							
		</div>

		<div class="container">

			<!--General Information -->
			<div class="container contact_tot">
			    <div class="panel panel-default">
			       <div class="panel-heading">			       
			         <label>CLAIM FORM </label>&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<i><label>PLEASE INCLUDE YOUR PET'S MEDICAL RECORD TO HELP EXPEDITE PROCESSING</label></i>			         
			      </div>			      
			    </div>
			</div>

			<!--General Information -->
			<div class="container contact_tot">
			    <div class="panel panel-default">
			       <div class="panel-heading">			       
			          <b>General Information</b> &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp <i><small>Please fill out this form completely. Incomplete forms will delay processing.</small></i>			         
			      </div>			      
			    </div>
			</div>
				
			<!--Personal Information -->
			<div class="form-group col-sm-6">
				
				<div class="panel panel-default">
				   <div class="panel-heading">			       
				      <b>Personal Information</b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp<i><small><label class="checkbox-inline"><input type="checkbox" name="New Address?" value="Yes">Check here if this is a new address</label></small></i>
				    </div>			      
			   	</div>
								
				<div class="form-group col-sm-6">
				<label>Name:</label><input type="text" name="Name" Placeholder="First &amp Last Name" class="form-control" />				
				</div>
				<div class="form-group col-sm-6">
				<label>Address:</label><input type="text" name="Address" Placeholder="Address" class="form-control" />					
				</div>	
				<div class="form-group col-sm-6">
				<label>City:</label><input type="text" name="City" Placeholder="City" class="form-control" />			
				</div>	
				<div class="form-group col-sm-6">
				<label>State:</label><input type="text" name="State" Placeholder="State" class="form-control" />				
				</div>	
				<div class="form-group col-sm-6">
				<label>Zip Code:</label><input type="text" name="Zip Code" Placeholder="Zip Code" class="form-control" />				
				</div>	
				<div class="form-group col-sm-6">
				<label>Phone Number:</label><input type="text" name="Contact Number" Placeholder="+1 (999)-999-9999" class="form-control" />								
				</div>	
				<div class="form-group col-sm-12">
				<label>Email ID:</label><input type="text" name="Email ID" Placeholder="abc@yahoo.com" class="form-control" />			
				</div>	
			</div>

			<!--Pet Information -->
			<div class="form-group col-sm-6">

				<div class="panel panel-default">
				   <div class="panel-heading">			       
				      <b>Pet Information</b>
				    </div>			      
			   	</div>
				
				<div class="form-group col-sm-6">
				<label>Account Number:</label><input type="text" name="Account Number" Placeholder="999-999-8888" class="form-control" />
				</div>
				<div class="form-group col-sm-6">
				<label>Name:</label><input type="text" name="Pet Name" Placeholder="Name of Pet" class="form-control" />			
				</div>	
				<div class="form-group col-sm-6">
				<label>Breed:</label><input type="text" name="Breed" Placeholder="Breed of Pet" class="form-control" />				
				</div>	
				<div class="form-group col-sm-6">
				<label>Age:</label><input type="text" name="Age" Placeholder="Age" class="form-control" />				
				</div>	
				<div class="form-group col-sm-12"></div>
				<div class="form-group col-sm-12"></div>
				<div class="form-group col-sm-3">
				<label>Gender:</label>
				</div>
				<div class="form-group col-sm-6">
				<p><label class="radio-inline"><input type="radio" name="Gender" value="Male" checked>Male</label>
				<label class="radio-inline"><input type="radio" name="Gender" value="Female">Female</label></p>				
				</div>	
			</div>	

			<!--Diagnosis/Symptom Information -->
			<div class="form-group col-sm-12">
				
				<div class="panel panel-default">
				   <div class="panel-heading">			       
				      <b>Diagnosis / System Information</b>
				    </div>			      
			   	</div>

			   	<label>Story of Occurence / Diagnosis</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<b><i><small>-Please describe this incident, including dates, details and symptons leading upto it.</small></i></b>		

				<textarea class="form-control" Placeholder="Brief disctiption of incident or any history of the condition" rows="5" name="Diagnosis"></textarea><br />

				<div class="form-group col-sm-6">
					<p><label>This claim is related to:</label></p>
					<label class="radio-inline"><input type="radio" name="Claim Related To" value="Accident" checked>Accident</label>
					<label class="radio-inline"><input type="radio" name="Claim Related To" value="Illness">Illness</label>
					<label class="radio-inline"><input type="radio" name="Claim Related To" value="Wellness">Wellness</label>
					<br />
					<br />

					<p><label>Is this claim an estimate for future treatment?</label></p>
					<label class="radio-inline"><input type="radio" name="Claim Estimate for Future?" value="Yes" checked>Yes</label>
					<label class="radio-inline"><input type="radio" name="Claim Estimate for Future?" value="No">No</label>
					<br />
					<br />

					<label>Total amount claimed:</label><input type="text" name="Amount Claimed" Placeholder="Amount Claim" class="form-control" />		
					<br />

					<label>Date Illness/Injury first occurred:</label><input type="date" name="Date Illness" class="form-control" />	
					<br />

					<p><label>Send Payment To:</label></p>
					<label class="radio-inline"><input type="radio" name="Send Payment to" value="Me" checked>Me</label>
					<label class="radio-inline"><input type="radio" name="Send Payment to" value="Veterinarian">Veterinarian</label>
					<br />
					<br />
						
					<p><label>Is this a new condition:</label></p>
					<label class="radio-inline"><input type="radio" name="New Condition?" value="Yes" checked>Yes</label>
					<label class="radio-inline"><input type="radio" name="New Condition?" value="No">No</label>					
					<br />
				</div>

				<div class="form-group col-sm-6">
					<label>Veterinarian:</label><input type="text" name="Veterinarian" Placeholder="Veterinarian" class="form-control" />	
					<br />

					<label>Clinic Name:</label><input type="text" name="Clinic Name" Placeholder="Name of Clinic" class="form-control" />
					<br />

					<label>Phone Number:</label><input type="text" name="Phone Number" Placeholder="+1 (999)-999-9999" class="form-control" />		
					<br />

					<label>Fax Number:</label><input type="text" name="Fax Number" Placeholder="+1 (999)-999-9999" class="form-control" />
					<br />

					<p><label>Did any other veterinarian treat your pet:</label></p>
					<label class="radio-inline"><input type="radio" name="Any other Veterinarian treated?" value="Yes" checked>Yes</label>
					<label class="radio-inline"><input type="radio" name="Any other Veterinarian treated?" value="No">No</label>		
					<br />


				</div>				
				
			<!--Pet Owner Declaration -->
			<div class="form-group col-sm-12">

				<div class="panel panel-default">
				   <div class="panel-heading">			       
				    	<b>Pet Owner Declaration</b>
					</div>			      
				</div>
				<label><input type="checkbox" name="Agreement" value="Yes">&nbsp&nbsp&nbsp<b>I confirm to the best of my knowledge the above statements are true in every respect. I understand that the fees listed may not be covered or may exceed my plan benefit. I understand that I am financially responsible to my veterinarian for the entire treatment. I understand that this claim cannot be adjusted without itemized receipts. I also understand that the deliberate misrepresentation of the animal”s condition or the omission of any material facts may result in the denial of the claim and/or the cancellation of coverage. I authorize United States Fire Insurance Company and its business partners to review and obtain a copy of ALL RECORDS including the insurance claim records and medical records as to examination, history, diagnosis, treatment and prognosis with respect to any condition. I further authorize these entities to disclose identifying information about me and my pet, as well as information about my claim experience, to my veterinarian.</b></label>
				
			</div>

			<div class="form-group col-sm-12">
				
				<div class="form-group col-sm-9">
  				<label>Signature of Pet Owner:</label><input type="text" Placeholder="Full Name of Pet Owner" name="Signature" class="form-control" />
  				</div>

				<div class="form-group col-sm-3">
  				<label>Date:</label><input type="date" name="Date" class="form-control" />
				</div>
			
				<div class="form-group col-sm-12">
                                    <button type="submit" id="submit" name="submit" class="btn btn-primary btn-md" onclick="switchVisible()">SUBMIT</button>
				</div>
				<hr />

				<div class="bg-danger text-center col-sm-12">
				<h5>Please read IMPORTANT NOTICE document that follows for additional information</h3>
				</div>
			</div>
                        </div>
		</div>
	</form>		
        </div>
        </body>
</html>
        
        
        <jsp:scriptlet>
            if (request.getMethod().equalsIgnoreCase("post"))  {                
        </jsp:scriptlet>

    <html>
        <body onload='onload=($("#quest").hide())'>
        <div id="formValues" class="insurance">
		
            <div class="well">
		<center><label>Thank you for submitting the form</label></center>
		<center><label>Your request will be processed shortly</label></center>
            <hr />
            </div>
            
		<div class="container">
  
  		<table border="1" width=100% class="table table-hover">
	    	<thead>
	      	<tr>
	        <th>Field Name</th>
	        <th>Details</th>
	      	</tr>
	    	</thead>
    		<tbody>

    		<tr>
    			<td>Name: </td>
                        <td><jsp:expression>request.getParameter("Name")</jsp:expression></td>
    		</tr>
                <tr>
                    <td>Is this New Address?: </td>
                    <td><jsp:expression>request.getParameter("New Address?")</jsp:expression></td>
                </tr>
    		<tr>
    			<td>Address: </td>
    			<td><jsp:expression> request.getParameter("Address") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>City: </td>
    			<td><jsp:expression> request.getParameter("City") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>State: </td>
    			<td><jsp:expression> request.getParameter("State") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Zip Code: </td>
    			<td><jsp:expression> request.getParameter("Zip Code") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Contact Number: </td>
    			<td><jsp:expression> request.getParameter("Contact Number") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Email ID: </td>
    			<td><jsp:expression> request.getParameter("Email ID") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Account Number: </td>
    			<td><jsp:expression> request.getParameter("Account Number") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Pet Name: </td>
    			<td><jsp:expression> request.getParameter("Pet Name") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Breed: </td>
    			<td><jsp:expression> request.getParameter("Breed") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Age: </td>
    			<td><jsp:expression> request.getParameter("Age") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Gender: </td>
    			<td><jsp:expression> request.getParameter("Gender") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Diagnosis: </td>
    			<td><jsp:expression> request.getParameter("Diagnosis") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>This claim is related to: </td>
    			<td><jsp:expression> request.getParameter("Claim Related To") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Is Claim Estimate for Future?:</td>
    			<td><jsp:expression> request.getParameter("Claim Estimate for Future?") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Total Amount claimed: </td>
    			<td><jsp:expression> request.getParameter("Amount Claimed") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Date Illness: </td>
    			<td><jsp:expression> request.getParameter("Date Illness") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Send Payment to: </td>
    			<td><jsp:expression> request.getParameter("Send Payment to") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Veterinarian: </td>
    			<td><jsp:expression> request.getParameter("Veterinarian") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Clinic Name: </td>
    			<td><jsp:expression> request.getParameter("Clinic Name") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Phone Number: </td>
    			<td><jsp:expression> request.getParameter("Phone Number") </jsp:expression></td>
    		</tr>
			<tr>
    			<td>Fax Number: </td>
    			<td><jsp:expression> request.getParameter("Fax Number") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Did any other veterinarian treat your pet?: </td>
    			<td><jsp:expression> request.getParameter("Any other Veterinarian treated?") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Is this a new condition: </td>
    			<td><jsp:expression> request.getParameter("New Condition?") </jsp:expression></td>
    		</tr>
            <tr>
                <td>Agreement: </td>
                <td><jsp:expression> request.getParameter("Agreement") </jsp:expression></td>
            </tr>
    		<tr>
    			<td>Signature: </td>
    			<td><jsp:expression> request.getParameter("Signature") </jsp:expression></td>
    		</tr>
    		<tr>
    			<td>Date: </td>
    			<td><jsp:expression> request.getParameter("Date") </jsp:expression></td>
    		</tr>

			</tbody	
		</div>	
            
            </div>
                    
        </div>
                    
    </body>
</html>
<jsp:scriptlet>  }  </jsp:scriptlet>
