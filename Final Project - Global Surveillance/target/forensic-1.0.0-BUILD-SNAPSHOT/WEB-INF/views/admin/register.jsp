<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style type="text/css">
</style>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
<style type="text/css">
table.register {
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
	<form action="registerSuccess.htm" method="post">


		<table class="register" cellpadding="5" cellspacing="2" align="center">
			<tr>

				<td colspan="2" align="center">Welcome :&nbsp
					${sessionScope.userAccount.getUserName()} &nbsp</td>
			</tr>
			<tr>

				<td colspan="2" align="center">ADD USER</td>
			</tr>
			<tr>
				<td></td>

				<td align="left"><input type="radio" value="Manufacturer"
					name="registerRole" checked="checked">Manufacturer</td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><input type="radio" value="Distributor" name="registerRole">Distributor</td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><input type="radio" value="Dispenser" name="registerRole">Dispenser</td>
			</tr>

			<tr>
				<td align="left">First Name</td>
				<td><input id="id1" type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input id="id2" type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><input id="id3" type="text" name="registerUserName"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input id="id4" type="password" name="registerPassword"></td>
			</tr>
			<tr>
				<td>ReEnter Password</td>
				<td><input id="id5" type="password" name="reenterPassword"></td>
			</tr>

			<tr>
				<td>Enterprise Name</td>
				<td><input id="id6" type="text" name="enterpriseName"></td>
			</tr>
			<tr>
				<td>e-Mail Id</td>
				<td><input id="id8" type="text" name="email"></td>
			</tr>
			<tr>
				<td>User Address</td>
				<td><input id="id7" type="text" name="address"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" id="button"
					style="background-color: #808080" value="submit"
					onclick="return validate()">
		</table>
	</form>
	<script>
		function validate() {
			var i1 = document.getElementById("id1").value;
			i1 = i1.trim();
			var i2 = document.getElementById("id2").value;
			i2 = i2.trim();
			var i3 = document.getElementById("id3").value;
			i3 = i3.trim();
			var i4 = document.getElementById("id4").value;
			var i5 = document.getElementById("id5").value;
			var i6 = document.getElementById("id6").value;
			i6 = i6.trim();
			var i7 = document.getElementById("id7").value;
			i7 = i7.trim();
			var i8 = document.getElementById("id8").value;
			i8 = i8.trim();

			if (i1 == "" || i2 == "" || i3 == "" || i4 == "" || i5 == ""
					|| i6 == "" || i7 == ""||i8=="") {
				alert("Emepty Values Not Allowed");
				return false;
			}

			if (i4 != i5) {
				alert("Password Mismatch");
				return false;
			}
			if (i3.indexOf('<') != -1 || i3.indexOf('>') != -1
					|| i3.indexOf(':') != -1 || i3.indexOf(';') != -1
					|| i3.indexOf('&') != -1 || i3.indexOf('$') != -1) {
				alert("Username Contains Special Character");
				return false;
			}
			var atpos=i8.indexOf("@");
			var dotpos=i8.lastIndexOf(".");
			if (atpos<1 || dotpos<atpos+2 || dotpos+2 >= i8.length)
			  {
			  alert("Not a valid e-mail address");
			  return false;
			  }
		}
	</script>

</body>
</html>