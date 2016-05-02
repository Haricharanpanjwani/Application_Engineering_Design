<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/drug.css">
<title>Report Generation</title>
</head>
<body>
<body>
	<form method="POST"  action="generalReport.htm" onchange="submit()">
		<div>
			<table class="drug">
				<tr> <td colspan="3" >Welcome: ${user.getUserName()}</td> </tr>
				<tr> <td colspan="3">Report Generation Table</td> </tr>
				
				<tr>
					<th> Enterprise ID </th>
					<!-- <th> Enterprise Name </th>
					<th> Enterprise Type </th> -->
				</tr>
				
				<c:forEach var="enterprise" items="${reportList}">
					<tr>
						<td><c:out value="${enterprise.enterpriseName}" /></td>						
					</tr>

				</c:forEach>
			</table>
			</table>
		</div>
	</form>
</body>
</html>