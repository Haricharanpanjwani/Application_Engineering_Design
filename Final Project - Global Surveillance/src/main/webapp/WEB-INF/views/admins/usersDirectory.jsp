<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js'></script>
<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js'></script>
<link rel="stylesheet" type="text/css" href="resources/css/drug.css">
<title>User Directory</title>
</head>
<body>
	<form action="usersDirectory.htm" method="POST" onchange="submit()">
				
		<table class="search" align="center" style="background-color:#e0e0e0;">
				<tr>					
					<td colspan = "3">Search User : <input type="text" id="search" name="search" /></td>
					<td colspan = "2"/>
					<td colspan = "2"><input type="radio" name="reset" value="Reset">Reset</td> 
				</tr>
		</table>
		<div>												
			<table class="drug">
								
				<tr> <td colspan="5">Welcome : ${user.getUserName()}</td> </tr>
				
				<tr> <td colspan="5">User Directory</td> </tr>

				<tr>
					<th> User ID </th>
					<th> UserName </th>
					<th> Full Name </th>
					<th> Role </th>
					<th> Enterprise </th>
				</tr>
				
				<c:forEach var="user" items="${userList}">
					<tr>
						<td><c:out value="${user.personID}" /></td>
						<td><c:out value="${user.userName}" /></td>
						<td><c:out value="${user.firstName} ${user.lastName}" /></td>
						<td><c:out value="${user.role}" /></td>
						<td><c:out value="${user.enterprise.enterpriseName}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>

	<script>
	//onchange="youFunction();"
	$("#search").chang("input",function(){
		var searc = $(this).val();
		alert(searc);
		$.ajax({
			url:"search.htm", data: {'searchString' : searc},
			success : function(response){				

				var html = "<tr>";
				
				<c:forEach var="user" items="${userList}">

				<tr>
					<td><c:out value="${user.personID}" /></td>
					<td><c:out value="${user.userName}" /></td>
					<td><c:out value="${user.firstName} ${user.lastName}" /></td>
					<td><c:out value="${user.role}" /></td>
					<td><c:out value="${user.enterprise.enterpriseName}" /></td>
				</tr>
			</c:forEach>

				for (var i = 0; i < userList.length; i++) {
				    var o = response[i];
				    html += "<td>" + o.regNo + " " + o.name + "</td>";
				}
				
				html += "</tr>";
				$('.t3').html(html);
				
			},
		});
	});
	</script>
</body>
</html>