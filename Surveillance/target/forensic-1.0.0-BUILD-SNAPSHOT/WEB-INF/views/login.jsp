
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/login.css">
<script>
 function validateForm()	{
	 		
        	var name = document.getElementById("name").value;
        	name = name.trim();
        	
        	var pass = document.getElementById("pass").value;
      		pass = pass.trim();
      		
      		if(name == ""|| pass == "")	{
      				alert("Username and Password cannot be empty!!");
  					return false;	
  			}
	}
 </script>
</head>
<body>
<form method="post" action="signIn.htm" >
	<table class="signIn" >
		<tr>
			<td colspan="2"><b>UserAccount Login</b></td>
		</tr>
		<tr>
			<td>UserName : </td> <td> <input id="name" type="text" name="userName"/></td>
		</tr>
		<tr>
			<td>Password : </td> <td> <input id="pass" type="password" name="password"/></td>
		</tr>
		<tr>
			<td colspan="2"> <input type="submit" id="button" value="Log In" onclick="return validateForm()" /> </td>
		</tr>
	</table>
</form>

</body>
</html>
