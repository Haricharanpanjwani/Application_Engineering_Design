<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
 <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/drug.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
 <link rel="stylesheet" href="/resources/demos/style.css">
<title>Drug Inventory</title>

<script>
 $(function() {
   $("#datepicker").datepicker();
   $("#datepickers").datepicker();
 });
</script>
 
</head>
<body>
	<form method="POST" action="drugReport.htm">
		
		<table class="search" align="center" style="background-color:#e0e0e0;">
			<tr>					
				<td colspan = "2">Min Quantity : <input type="number" id="min" name="min" /></td>
				<td colspan = "2">Max Quantity : <input type="number" id="max" name="max" /></td>
				<td colspan = "2"><input type="submit" name="submit" value="submit"></td>				 
			</tr>
			<tr>
				<td colspan = "2"><input type="radio" name="filter" value="asc">Ascending</td>
				<td colspan = "2"><input type="radio" name="filter" value="desc">Descending</td>
				<td colspan = "2"><input type="radio" name="reset" value="Reset">Reset</td>
			</tr>
		</table>
		
		<!-- <table class="search" align="center" style="background-color:#e0e0e0;">
			<tr>					
				<td colspan = "2">Start Date : <input type="text" id="datepicker" name="minDate" /></td>
				<td colspan = "2">End Date : <input type="text" id="datepickers" name="maxDate" /></td>
				<td colspan = "2"><input type="submit" name="submit" value="submit"></td>				 
			</tr>
			<tr>
				<td colspan = "2"><input type="radio" name="filterDate" value="asc">Ascending</td>
				<td colspan = "2"><input type="radio" name="filterDate" value="desc">Descending</td>
				<td colspan = "2"><input type="radio" name="resetDate" value="Reset">Reset</td>
			</tr>
		</table> -->
		
		<div>
			<table class="drug">
				
				<tr> <td colspan="5">Welcome : ${user.getUserName()}</td> </tr>
				
				<tr> <td colspan="5">Drug Inventory </td> </tr>
				
				<tr>
					<th> Drug ID </th>
					<th> Drug Name </th>
					<th> Drug Quantity </th>
					<th> Expiry Date </th>
					<th> Enterprise Name </th>
				</tr>
				
				<c:forEach var="drug" items="${drugList}">
					<tr>
						<td><c:out value="${drug.drugId}" /></td>
						<td><c:out value="${drug.drugName}" /></td>
						<td><c:out value="${drug.quantity}" /></td>
						<td><c:out value="${drug.expiryDate}" /></td>
						<td><c:out value="${drug.enterprise.enterpriseName}" /></td>
					</tr>
				</c:forEach>
			</table>
			
			<input type="hidden" name="type" value="drugs" />
			
		</div>
	</form>
</body>
</html>