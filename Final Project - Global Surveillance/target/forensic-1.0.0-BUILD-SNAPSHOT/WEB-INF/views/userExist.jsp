<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<script type='text/javascript' src='resources/js/validation.js'></script>
<link rel="stylesheet" type="text/css" href="resources/css/error.css">
<title>Error Page</title>
	
	<script type="text/javascript">
		alert("UserAccount already exist!!");
	</script>
	
	<script type="text/javascript">

function validateForm() {
	
	var fName = document.getElementById("fName").value;
	fName = fName.trim();
	
	var lName = document.getElementById("lName").value;
	lName = lName.trim();
	
	var name = document.getElementById("name").value;
	name = name.trim();
	
	var pass = document.getElementById("pass").value;
	var repass = document.getElementById("repass").value;
	
	var enterp = document.getElementById("enterp").value;
	enterp = enterp.trim();
	
	var address = document.getElementById("address").value;
	address = address.trim();
	
	var email = document.getElementById("email").value;
	email = email.trim();

	if (fName == "" || lName == "" || name == "" || pass == "" || repass == "" || enterp == "" || address == ""|| email == "") {
		alert("Empty fields are not allowed!!");
		return false;
	}

	if (pass != repass) {
		alert("Password and Confirm Password does not match");
		return false;
	}
	
	if (pass.length < 6) {
		alert("Password should be of minimum 6 characters");
		return false;
	}
	
	if (name.indexOf('<') != -1 || name.indexOf('>') != -1
			|| name.indexOf(':') != -1 || name.indexOf(';') != -1
			|| name.indexOf('&') != -1 || name.indexOf('$') != -1) {
		alert("Username cannot contain special characters");
		return false;
	}
	
	var atPosition = email.indexOf("@");
	var dotPosition = email.lastIndexOf(".");
	
	if (atPosition < 1 || dotPosition<atPosition+2 || dotPosition+2 >= email.length)	{
		  alert("Email address is not valid!!");
		  return false;
	 }
}
</script>
	
</head>
<body>
	<form method="POST" action="registerationSuccess.htm">
		
		<p align="center">You Are:
			${user.getUserName()}</p>
			
		<h3 align="center">Register UserAccount</h3>
		<table class="errorPage" cellpadding="5" cellspacing="2" align="center">
			<tr>
				<td></td>

				<td align="left"><input type="radio" value="Manufacturer"
					name="role" checked="checked">Manufacturer</td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><input type="radio" value="Distributor" name="role">Distributor</td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><input type="radio" value="Dispenser" name="role">Dispenser</td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input id="fName" type="text" name="fName"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input id="lName" type="text" name="lName"></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><input id="name" type="text" name="userName"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input id="pass" type="password" name="password"></td>
			</tr>
			<tr>
				<td>Reenter Password</td>
				<td><input id="repass" type="password" name="rePassword"></td>
			</tr>

			<tr>
				<td>Enterprise Name</td>
				<td><input id="enterp" type="text" name="enterpriseName"></td>
			</tr>
			<tr>
				<td>Email Id</td>
				<td><input id="email" type="text" name="email"></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input id="address" type="text" name="address"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input id="button" type="submit"	value="Register" onclick="return validateForm()">
		</table>
	</form>
</body>
</html>