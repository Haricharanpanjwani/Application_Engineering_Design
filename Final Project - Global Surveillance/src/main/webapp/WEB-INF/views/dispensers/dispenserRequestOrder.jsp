<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="resources/css/orderReceive.css">
</head>
<body>
	<div class="request">
		<table class="orderReceive">
			<tr> <td colspan="5">Welcome : ${user.getUserName()}</td> </tr>
			<tr>
				<td colspan="5">Requested Drugs</td>
			</tr>

			<tr>
				<th> Work Request ID </th>
				<th> Drug Name </th>
				<th> Drug Quantity </th>
				<th> To Distributor</th>
				<th> Request Status </th>
			</tr>
			<c:forEach var="request" items="${senderList}">

				<tr>
					<td><c:out value="${request.requestId}" /></td>
					<td><c:out value="${request.drugName}" /></td>
					<td><c:out value="${request.quantity}" /></td>
					<td><c:out value="${request.enterpriseReceiver.enterpriseName}" /></td>
					<td><c:out value="${request.status}" /></td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>