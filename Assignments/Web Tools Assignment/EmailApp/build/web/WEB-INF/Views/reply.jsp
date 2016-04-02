<%-- 
    Document   : reply
    Created on : Feb 6, 2016, 12:00:39 PM
    Author     : hpanjwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reply Email</title>
    </head>
    <body>
        <h1>Welcome <c:out value="${sessionScope.userName}"></c:out></h1>
        
        <form action="sendMessage.htm" method="POST">
            <h3>From: <c:out value="${sessionScope.userName}"></c:out></h3>
            <h3>To: ${param.to} </h3>
            <h3>Message:
                <textarea name='message' rows='10' cols='20'></textarea>
            </h3>
            
            <input type='submit' value='Send' />
            <input type='hidden' name='to' value='${param.to}' />
        </form>
    </body>
</html>
