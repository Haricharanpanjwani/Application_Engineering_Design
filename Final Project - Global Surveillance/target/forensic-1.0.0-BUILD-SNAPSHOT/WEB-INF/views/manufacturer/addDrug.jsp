<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%-- <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<style type="text/css">
table.t7 {
	width: 400px;
	height: 180px;
	margin: 30px 50px;
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
	width: 200px;
	height: 30px;
	border-radius: 2px;
	font-weight: bolder;
	font-size: 12px;
}
</style>
</head>
<body>
	<form action="addDrugProcess.htm">
		<table class="t7" cellpadding="5" cellspacing="5" align="center">

			<tr>
				<td colspan="2" align="center">Welcome :&nbsp
					${sessionScope.userAccount.getUserName()}</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><h3>ADD DRUG</h3></td>
			</tr>
			<tr>
				<td>Drug Name</td>
				<td><input id="id1" type="text" name="drugname"></td>
			</tr>
			<tr></tr>
			<tr>
				<td>Quantity</td>
				<td><input type="number" min="1" max="9999999" name="quantity"
					id="id3"></td>
			</tr>
			<tr></tr>
			<tr>
				<td>Enterprise Name</td>
				<td><input type="text" disabled="disabled"
					name="enterpriseName"
					value="${sessionScope.enterprise.getEnterpriseName()}"></td>
			</tr>
			<tr></tr>
			<tr>
				<td>Expiry Date</td>
				<td><input type="date" id="id2" name="expirydate"></td>
			</tr>
			<tr></tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" id="button"
					style="background-color: #808080" value="submit"
					onclick="return validate()"></td>
			</tr>
		</table>
	</form>
	<script>
		function validate() {
			var i1 = document.getElementById("id1").value;
			var i2 = document.getElementById("id2").value;
			var i3 = document.getElementById("id3").value;
			i1 = i1.trim();
			i2 = i2.trim();
			i3 = i3.trim();
			if (i1 == "" || i2 == "" || i3 == "") {
				alert("Do not Leave Fields empty");
				return false;
			}
		}
	</script>
</body>
</html>


