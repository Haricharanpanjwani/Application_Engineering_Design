<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="resources/css/drug.css">
<title>Drug Inventory</title>
</head>
<body>

<div>
	<table class="drug">
	<tr> <td colspan="5">Welcome : ${user.getUserName()}</td> </tr>
	<tr> <td colspan="5">Drug Inventory</td></tr>
	<tr>
		<th> Drug ID </th>
		<th> Drug Name</th> 
		<th> Quantity </th> 
		<th> Expiration Date</th>
	</tr>  
		<c:forEach var="drug" items="${drugList}">
	
			<tr>
				<td><c:out value="${drug.drugId}" /></td>
				<td><c:out value="${drug.drugName}" /></td>
				<td><c:out value="${drug.quantity}" /></td>
				<td><c:out value="${drug.expiryDate}" /></td>
			</tr>
				
		</c:forEach>
	</table>
</div>
</body>
</html>