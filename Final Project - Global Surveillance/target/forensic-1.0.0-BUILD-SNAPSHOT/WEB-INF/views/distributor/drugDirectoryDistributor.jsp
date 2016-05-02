<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
<style>
table.t14 {
	width: 350px;
	height: 200px;
	background-color: #e0e0e0;
	border: silver;
	border-radius: 10px;
	opacity: 0.7;
}

td {
	text-align: center;
	font-weight: 600;
}
</style>
</head>
<body>
	<div align="left"
		style="width: 520px; height: 350px; overflow: scroll; margin-left: 100px">
		<table class="t14" border="2" cellpadding="5" cellspacing="2"
			width="500" align="center">
			<tr>
				<td colspan="4">You Are:
					${sessionScope.userAccount.getUserName()}</td>
			</tr>
			<tr>
				<td colspan="4">Drug Inventory</td>
			</tr>
			<tr>
				<th>Drug ID</th>
				<th>Drug Name</th>
				<th>Quantity</th>
				<th>Expiry Date</th>
			</tr>
			<c:forEach var="d" items="${drugList}">

				<tr>
					<td><c:out value="${d.drugId}" />
					<td><c:out value="${d.drugName}" />
					<td><c:out value="${d.amount}" />
					<td><c:out value="${d.expiryDate}" />
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>