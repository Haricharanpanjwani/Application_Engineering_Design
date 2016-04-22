<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Drug Report Page</title>
</head>
<body>
<form action="reportType.htm" method="POST" onchange="submit()" >
	<div align="left" style="width: 570px; height: 350px; overflow: scroll; margin-left: 75px">
		<table class="t12" border="2" cellpadding="5" cellspacing="2"
			width="550" align="center">
			<tr>
				<td colspan="5">Welcome :&nbsp
					${sessionScope.userAccount.getUserName()}</td>
			</tr>
			<tr>
				<td colspan="5">Drug Report</td>
			</tr>
			<tr>
				<td><input type="radio" name="filter" value="asc">Ascending</td>
				<td><input type="radio" name="filter" value="desc">Descending</td>
				<td>
					<select name="filter">
						<option name="" value="">Please select the price</option>
						<option name="filter" value="100"> greater than 100</option>
						<option name="filter" value="200"> greater than 200</option>
					</select>
				</td>
			</tr>			
			<tr>
				<th>Drug Id</th>
				<th>Drug Name</th>
				<th>Quantity</th>
				<th>Enterprise</th>
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
		<input type="hidden" name="type" value="drugs" />
	</div>
</form>
</body>
</html>