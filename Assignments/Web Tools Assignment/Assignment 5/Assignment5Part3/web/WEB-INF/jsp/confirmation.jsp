<%-- 
    Document   : confirmation
    Created on : Feb 9, 2016, 12:13:52 AM
    Author     : hpanjwani
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books Added</title>
    </head>
    <body>
        <p><c:out value="${sessionScope.noOfInsert}"/> books added successfully.</p>
         <a href="index.htm">Click here to go back to the main page</a>
    </body>
</html>
