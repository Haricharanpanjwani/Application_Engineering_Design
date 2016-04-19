<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>

<style type="text/css">
table.t17 {
	width: 400px;
	height: 180px;
	margin: 30px 50px;
	background-color: #e0e0e0;
	border: silver;
	border-radius: 10px;
	opacity: 0.7;
}

td {
	text-align: center;
	font-weight: 600;
}

#button {
	width: 200px;
	height: 30px;
	border-radius: 2px;
	font-weight: bolder;
	font-size: 12px;
}
</style>

<script type="text/javascript">

function getData(eid) {
	$.ajax({
		url:"givedrug.htm", data: {'comp' : eid},
		success : function(response){
			$('#drug').html(response);
			
		},
	});
}

</script>
</head>
<body>

<form action="orderRequestDistributor.htm">
<table class="t17" cellpadding="5" cellspacing="5" align="center">

<tr><td colspan="2" >You are: ${sessionScope.userAccount.getUserName()}</td></tr><tr>
<td colspan="2" align="center"><h3>Place Order</h3></td>
</tr>
<tr>
<td>Manufacturer </td> 
<td> 

<select name="man" onchange="getData(this.value)">
<option value="">Select</option>
<c:forEach var="d" items="${manlist}">

<option value="${d.enterpriseId}"><c:out value="${d.enterpriseName}" /></option>

</c:forEach>
</select>
</td>
</tr>

<tr>
<td>Quantity</td> <td> <input type="number" min="1" max="9999999" name="quantity" id="id2"></td>
</tr>
<tr>
<td>DrugName</td>
<td>
<select id="drug" name="drugName">

</select>

</td>
</tr>
<tr>
<td colspan="2" align="center"><input id="button" type="submit" style="background-color: #808080" value= "Submit" onclick="return validate()"></td>
</tr>
</table>
</form>
<script>
 function validate()
        {
        	var i1 = document.getElementById("drug").value;
        	var i2 = document.getElementById("id2").value;
      		i1 = i1.trim();
      		i2 = i2.trim();
      		if(i1=="" || i2=="")
      			{
      				alert("Do not Leave Fields emepty");
  					return false;
      			}	
        }
 </script>

</body>
</html>