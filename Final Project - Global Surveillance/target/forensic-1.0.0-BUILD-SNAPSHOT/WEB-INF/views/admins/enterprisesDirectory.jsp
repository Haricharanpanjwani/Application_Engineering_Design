<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="resources/css/drug.css">
<title>Enterprise Directory</title>
</head>
<body>
	
	<form method="POST" action="enterprisesDirectory.htm"  onchange="submit()">
	
		<table class="search" align="center" style="background-color:#e0e0e0;">
			<tr>
				<td colspan = "4">Search Enterprise : <input type="text" name="search" /></td>
				<td colspan = "4"><input type="submit" name="submit" /></td>
			</tr>
			<tr>						
				<td colspan = "2"><input type="radio" name="filter" value="manufacturer">Manufacturer</td>
				<td colspan = "2"><input type="radio" name="filter" value="distributor">Distributor</td>
				<td colspan = "2"><input type="radio" name="filter" value="dispenser">Dispenser</td>
				<td colspan = "2"><input type="radio" name="filter" value="all">All</td> 
			</tr>
		</table>
		<div>		
			<table class="drug">
				
				<tr> <td colspan="3" align="center">Welcome: ${user.getUserName()}</td> </tr>
				
				<tr> <td colspan="3" align="center">Enterprise Table</td> </tr>
				
				<tr>
					<th> Enterprise ID </th>
					<th> Enterprise Name </th>
					<th> Enterprise Type </th>
				</tr>
				
				<c:forEach var="enterprise" items="${enterpriseList}">
					<tr>
						<td><c:out value="${enterprise.enterpriseId}" /></td>
						<td><c:out value="${enterprise.enterpriseName}" /></td>
						<td><c:out value="${enterprise.role}" /></td>
					</tr>

				</c:forEach>
			</table>
			<input type="hidden" name="role" value="general" />
		</div>
	</form>
</body>
</html>