
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<style type="text/css">
table.myHome
{
	width:400px;
  	height:180px;
 	margin:30px 50px;
  	background-color:#e0e0e0;
 	border:silver;
 	border-radius :10px;
 	opacity:0.7;
 	cellpadding:"20";
 	cellspacing:"2";
 	
}

td 
{
	
  	text-align: center;
    font-weight:600;
  
}
#button
{
	width:150px;
	height:30px;
	border-radius :2px;
	font-weight:bolder;
	font-size: 12px;
}
</style>
</head>
<body>
<form action=signedIn.htm method="post">
<table class="myHome" >
<tr>
<td colspan="2"><b>User Login</b></td>
</tr>
<tr>
<td>UserName : </td> <td> <input id="id1" type="text" name="userName"/></td>
</tr>
<tr>
<td>Password : </td> <td> <input id="id2" type="password" name="password"/></td>
</tr>
<tr>
<td colspan="2"> <input type="submit" id="button" style="background-color: #888888" value="SignIn" onclick="return validate()" /> </td>
</tr>
</table>
</form>

<script>
 function validate()
        {
	 		
        	var i1 = document.getElementById("id1").value;
        	i1 = i1.trim();
        	var i2 = document.getElementById("id2").value;
      		
      		if(i1==""||i2=="")
      			{
      				alert("Emepty Username or Password not allowed");
  					return false;
      			}
        }
 </script>

</body>
</html>
