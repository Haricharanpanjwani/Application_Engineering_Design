<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="resources/css/orderReceive.css" />
<title>Place Order</title>
<script type="text/javascript">

function getData(enterpriseID) {	
	$.ajax({
		url:"giveEnterpriseDrug.htm", data: {'enterpriseID' : enterpriseID},
		success : function(response){
			$('#drug').html(response);
			
		},
	});
}

</script>
<script>
 function validateForm()
        {
        	var drug = document.getElementById("drug").value;
        	drug = drug.trim();
        	
        	var quant = document.getElementById("quant").value;      		
        	quant = quant.trim();
      		
      		if(drug == "" || quant == "") {
      				alert("Fields cannot be empty!!");
  					return false;	
  			}	
        }
 </script>
</head>

<body>

<form action="distributorRequestOrder.htm">
<table class="orderReceive" cellpadding="5" cellspacing="5" align="center">

		<tr> <td colspan="5">Welcome : ${user.getUserName()}</td> </tr>
		<tr>
			<td colspan="5">Order Drugs </td>
		</tr>
		<tr>
			<td>Manufacturer </td> 
			<td> 
			
			<select name="man" onchange="getData(this.value)">
			<option value="">Select</option>
			<c:forEach var="manufacturer" items="${manufactureList}">
			
			<option value="${manufacturer.enterpriseId}"><c:out value="${manufacturer.enterpriseName}" /></option>
			
			</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
<td>Quantity</td> <td> <input type="number" min="1" max="9999999" name="quantity" id="quant"></td>
</tr>
<tr>
<td>DrugName</td>
<td>
<select id="drug" name="drugName">

</select>

</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit"  id="button" value= "Order" onclick="return validateForm()"></td>
</tr>
</table>
</form>

</body>
</html>