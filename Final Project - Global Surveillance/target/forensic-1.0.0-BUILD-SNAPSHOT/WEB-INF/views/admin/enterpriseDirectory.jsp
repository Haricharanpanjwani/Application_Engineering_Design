<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
<style>
table.t2 {
	width: 500px;
	height: 330px;

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
		<table class="t2" border="2" cellpadding="5" cellspacing="2"
			width="500">
			<tr><td colspan="3" align="center">Welcome:${sessionScope.userAccount.getUserName()}</td></tr>
					<tr><td colspan="3" align="center">Enterprise Table</td></tr>
			<tr>
				<th>EnterpriseId</th>
				<th>EnterpriseName</th>
				<th>Role</th>
			</tr>
			<c:forEach var="d" items="${entlist}">
				<tr>
					
					<td><c:out value="${d.enterpriseId}" /></td>
					<td><c:out value="${d.enterpriseName}" /></td>
					<td><c:out value="${d.role}" /></td>
				</tr>

			</c:forEach>
		</table>
	</div>

</body>
</html>