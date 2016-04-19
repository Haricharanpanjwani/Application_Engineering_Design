<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
<style>
table.t12 {
	width: 350px;
	height: 250px;
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
	width: 70px;
	height: 30px;
	border-radius: 20px;
}
</style>

</head>
<body>


	<div align="left"
		style="width: 570px; height: 350px; overflow: scroll; margin-left: 75px">
		<table class="t12" border="2" cellpadding="5" cellspacing="2"
			width="550" align="center">
			<tr>
				<td colspan="5">Welcome :&nbsp
					${sessionScope.userAccount.getUserName()}</td>
			</tr>
			<tr>
				<td colspan="5">Request Drugs</td>
			</tr>

			<tr>
				<th>WorkRequest Id</th>
				<th>DrugName</th>
				<th>Quantity</th>
				<th>To Distributor</th>
				<th>Status</th>
			</tr>
			<c:forEach var="d" items="${slist}">

				<tr>
					<td><c:out value="${d.requestId}" /></td>
					<td><c:out value="${d.drugName}" /></td>
					<td><c:out value="${d.amount}" /></td>
					<td><c:out value="${d.enterpriseReceiver.enterpriseName}" /></td>
					<td><c:out value="${d.status}" /></td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>