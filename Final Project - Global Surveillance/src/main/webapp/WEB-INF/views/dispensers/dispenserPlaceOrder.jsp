<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="resources/css/orderReceive.css">
<title>Order Drug</title>

<script type="text/javascript">
	function getData(enterpriseID) {
		$.ajax({
			url : "giveEnterpriseDrug.htm",
			data : {
				'enterpriseID' : enterpriseID
			},
			success : function(response) {
				$('#drug').html(response);

			},
		});
	}
</script>
</head>
<body>

	<form method="get" action="dispenserOrderRequest.htm">
		<table class="orderReceive">
			<tr> <td colspan="5">Welcome : ${user.getUserName()}</td> </tr>
			<tr> <td colspan="2" align="center"><h3>Order Drugs</h3></td> </tr>

			<tr>
				<td>Distributor</td>
				<td><select name="dis" onchange="getData(this.value)">
						<option value="">Select</option>
						<c:forEach var="dispenser" items="${dispenserList}">

							<option value="${dispenser.enterpriseId}"><c:out
									value="${dispenser.enterpriseName}" /></option>

						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>Quantity</td>
				<td><input type="number" min="1" max="9999999" name="quantity" id="quantity"></td>
			</tr>
			<tr>
				<td>DrugName</td>
				<td><select id="drug" name="drugName">

				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input id="button" type="submit" value="Order" onclick="return validateForm()"></td>
			</tr>
		</table>
	</form>
	<script>
		function validateForm() {
			var drug = document.getElementById("drug").value;
			var quantity = document.getElementById("quantity").value;
			drug = drug.trim();
			quantity = quantity.trim();
			
			if (drug == "" || quantity == "") {
				alert("Do not Leave Fields emepty");
				return false;
			}
		}
	</script>
</body>
</html>