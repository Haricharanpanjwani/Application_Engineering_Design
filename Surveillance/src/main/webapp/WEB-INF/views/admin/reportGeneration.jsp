<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Report Generation</title>
</head>
<body>
<body>
	<form action="reportType.htm" method="POST" onchange="submit()" >
	
		<div align="left" style="width: 520px; height: 350px; overflow: scroll; margin-left: 100px">
			<table class="t2" border="2" cellpadding="5" cellspacing="2" width="500">
				<tr><td colspan="3" align="center">Welcome: ${sessionScope.userAccount.getUserName()}</td></tr>
						<tr><td colspan="3" align="center">Report Generation Table</td></tr>			
			
				<tr><td><input type="radio" name="type" value="drugs">Report for Drugs</td></tr>
				<tr><td><input type="radio" name="type" value="manufacturer">Report for Manufacturer</td></tr>
				<tr><td><input type="radio" name="type" value="general">Report</td></tr>
			</table>
		</div>
	</form>

</body>
</html>