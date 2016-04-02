<%-- 
    Document   : reply
    Created on : 6 Feb, 2016, 3:33:57 PM
    Author     : Kiran
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compose Message</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <form action="sendMessage.htm" method="post">
            <h3>From:</h3>
            <c:out value="${sessionScope.userName}"></c:out>
            <h3>To:</h3>${param.to}
            <h3>Message:</h3>
            <textarea name="message" rows="6" cols="10"></textarea>
            <br /><input type="submit" value="Send" /> 

            <input type="hidden" name="to" value="${param.to}"/>          
        </form>
    </body>
</html>
