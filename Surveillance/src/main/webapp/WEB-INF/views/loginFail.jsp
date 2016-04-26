<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="resources/css/loginFail.css">
	<script type="text/javascript">
		alert("Invalid UserName And Password");
	</script>
	<script>
		function validateForm()	{
			 		
		        	var name = document.getElementById("name").value;
		        	name = name.trim();
		        	
		        	var pass = document.getElementById("pass").value;
		        	pass = pass.trim();
		        	
		      		if(name == ""|| pass == "")	{
						alert("Username and password cannot be empty");
		  				return false;
					}
		}
	</script>	
</head>
<body>
	<form method="post" action="signIn.htm">
		<table class="loginFail">
			<tr>
			<td>UserName : </td> <td> <input id="name" type="text" name="userName"/></td>
			</tr>
			<tr>
				<td>Password : </td> <td> <input id="pass" type="password" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" id="submitButton" value="LogIn" onclick="return validateForm()" /> </td>
			</tr>
		</table>
	</form>
</body>
</html>