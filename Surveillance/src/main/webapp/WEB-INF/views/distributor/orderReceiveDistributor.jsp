<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>

<style type="text/css">
table.t15 {
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

<p align="right">You Are: ${sessionScope.userAccount.getUserName()}</p>
<h3 align="center">Received Drugs</h3>
<div align="left" style="width: 570px; height: 250px; overflow: scroll;margin-left: 75px">
<table class="t15"border="2" cellpadding="5" cellspacing="2" width="550" align="center">
<tr>
<th> WorkRequest Id </th><th> DrugName</th> <th> Quantity </th> <th>From Dispenser</th> <th>Status</th>
</tr>  
	<c:set var="index" value="${1}"/>  
	<c:forEach var="d" items="${slist}">

		<tr id="${d.requestId}">
			<td><c:out value="${d.requestId}" />
			<td><c:out value="${d.drugName}" />
			<td><c:out value="${d.quantity}" />
			<td><c:out value="${d.enterpriseSender.enterpriseName}" />
			<td id="status${d.requestId}"><c:out value="${d.status}" />
		</tr>
		
		<input type="hidden" id="rowNo${index}" value="${d.requestId}">				
		<c:set var="index" value="${index+1}"/>
		
	</c:forEach>
</table>
</div>
<div align="right">
<form action="requestProcessDistributor.htm">

<h5> Enter WorkRequest ID:<input type="number" min="1" max="100" name="distriwrid" value="1" id="id3"/></h5>
<input type="submit" id="button" style="background-color: #808080" value="Process" onclick="return validate()"/>

</form>
</div>
<script type="text/javascript">
	function validate()	{
			/* var i3 = document.getElementById("id3").value;
			i3 = i3.trim();
			if(i3 == null || i3 == "")	{
					alert("Do not Leave Fields emepty");
					return false;
			} */
			
		  var xmlHttp;
	      xmlHttp = GetXmlHttpObject();
	
	      if (xmlHttp == null)	{
	         alert("Your browser does not support AJAX!");
	         return;
	      }
	 
	      var requestID = document.getElementById("id3").value;
	      
	      var query = "distriwrid=" + requestID;
	          
			xmlHttp.onreadystatechange = function stateChanged()	{
			            	        
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200)	{
			        
			        document.getElementById("status"+requestID).innerHTML="Processed";			        		      
		         }
	      };
	          
			xmlHttp.open("POST", "requestProcessDistributor.htm", true);
	      xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	      xmlHttp.send(query);
	          
	      return false;  
		}
		
		function GetXmlHttpObject()	{
	      var xmlHttp = null;
	      try	{
	          // Firefox, Opera 8.0+, Safari
	          xmlHttp = new XMLHttpRequest();
	      } 
	      catch (e)	{
	          // Internet Explorer
	          try	{
	              xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
	          } 
	          catch (e)	{
	              xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	          }
	      }
	      return xmlHttp;
	  }
 </script>
</body>
</html>