<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page session="false" %>
<html>
<head>
<style type="text/css">
table.t4
{
	width:400px;
  	height:180px;
 	margin:30px 50px;
  	background-color:#e0e0e0;
 	border:silver;
 	border-radius :10px;
 	opacity:0.7;	
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
	font-size: 15px;
}
</style>
</head>
<body>
<form action=signedIn.htm method="post">
<table class="t4" cellpadding="20" cellspacing="2">
<tr>
<td>UserName : </td> <td> <input id="id1" type="text" name="userName"/></td>
</tr>
<tr>
<td>Password : </td> <td> <input id="id2" type="password" name="password"/></td>
</tr>
<tr>
<td colspan="2"> <input type="submit" id="button" style="background-color: #808080" value="SignIn" onclick="return validate()" /> </td>
</tr>
</table>
</form>
<script type="text/javascript">
alert("Invalid UserName And Password");
</script>
<script>
 function validate()
        {
	 		
        	var i1 = document.getElementById("id1").value;
        	i1 = i1.trim();
        	var i2 = document.getElementById("id2").value;
      		
      		if(i1==""||i2=="")
      			{
      				alert("Empty Username or Password not allowed");
  					return false;
      			}
        }
 </script>

</body>
</html>