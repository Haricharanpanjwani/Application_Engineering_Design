<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/drug.css">
<title>Report</title>
</head>
<body>
	<form action="reportType.ht" method="POST" onchange="submit()">
		<div>
			<table class="drug">
				<tr> <td colspan="5">Welcome : ${user.getUserName()}</td> </tr>
				<tr> <td colspan="5">Drug Report</td> </tr>
				<tr>
					<td><input type="radio" name="filter" value="manufacturer">Manufacturer</td>
					<td><input type="radio" name="filter" value="distributor">Distributor</td>
					<td><input type="radio" name="filter" value="dispenser">Dispenser</td>
					<td><select name="filter">
							<option name="" value="">Please select the price</option>
							<option name="filter" value="100">greater than 100</option>
							<option name="filter" value="200">greater than 200</option>
					</select></td>
				</tr>
				<tr>
					<th> Drug ID </th>
					<th> Drug Name </th>
					<th> Drug Quantity </th>
					<th> Enterprise Name </th>
				</tr>
				<c:forEach var="drug" items="${drugList}">
					<tr>
						<td><c:out value="${drug.drugId}" /></td>
						<td><c:out value="${drug.drugName}" /></td>
						<td><c:out value="${drug.quantity}" /></td>
						<td><c:out value="${drug.enterprise.enterpriseName}" /></td>
					</tr>
				</c:forEach>
			</table>
			<input type="hidden" name="type" value="general" />
		</div>
	</form>
</body>
</html>