<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tile"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%-- <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="resources/css/login.css">
	<script>
		function validateForm() {
			var name = document.getElementById("name").value;
			var date = document.getElementById("date").value;
			var quant = document.getElementById("quant").value;
			
			name = name.trim();
			date = date.trim();
			quant = quant.trim();
			
			if (name == "" || quant == "" || date == "") {
				alert("Fields cannot be empty");
				return false;
			}
		}
	</script>
<title><tile:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<form action="drugAddProcess.htm">
		<table class="signIn" cellpadding="5" cellspacing="5" align="center">

			<tr> <td colspan="5">Welcome : ${user.getUserName()}</td> </tr>
			<tr>
				<td colspan="2" align="center"><h3>Order Drugs </h3></td>
			</tr>
			<tr>
				<td>Drug Name</td>
				<td><input id="name" type="text" name="drugname"></td>
			</tr>
			<tr></tr>
			<tr>
				<td>Quantity</td>
				<td><input type="number" min="1" max="9999999" name="quantity" id="quant"></td>
			</tr>
			<tr></tr>
			<tr>
				<td>Enterprise Name</td>
				<td><input type="text" disabled="disabled" name="enterpriseName"
					value="${enterp.getEnterpriseName()}"></td>
			</tr>
			<tr></tr>
			<tr>
				<td>Expiration Date</td>
				<td><input type="date" id="date" name="expirydate"></td>
			</tr>
			<tr></tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" id="button" value="Order" onclick="return validateForm()"></td>
			</tr>
		</table>
	</form>
</body>
</html>


