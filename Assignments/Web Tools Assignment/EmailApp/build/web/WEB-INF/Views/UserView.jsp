<%-- 
    Document   : UserView
    Created on : Feb 6, 2016, 11:44:18 AM
    Author     : hpanjwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Messages</title>
    </head>
    <body>        
        <h1>Welcome <c:out value="${sessionScope.userName}"></c:out></h1>
        
        <table border ="1">
            <tr>
                <th>From</th>
                <th>Messages</th>
                <th></th>
                <th>Message Date</th>
                <th></th>
            </tr>
            
        <c:forEach var="message" items="${sessionScope.messageList}">
            <tr>
                <td><c:out value="${message.fromUser}"></c:out></td>
                <td><c:out value="${message.message}"></c:out></td>
                <td><a href='reply.htm?to=<c:out value="${message.fromUser}" />&action=reply'>Reply</a><c:out value="${message.fromUser}"></c:out></td>
                <td><c:out value="${message.messageDate}"></c:out></td>
                <td><a href='#'>Delete</a></td>
            </tr>
        </c:forEach>
            
        </table>
    </body>
</html>
