<%-- 
    Document   : UserView
    Created on : 6 Feb, 2016, 3:17:06 PM
    Author     : Kiran
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User View</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1>Welcome <c:out value="${sessionScope.userName}"></c:out></h1>
        <table>
            <tr>
                <th>From</th>
                <th>Message</th>
                <th></th>
                <th>Message Date</th>
                <th></th>
            </tr>
            
        <c:forEach var="message" items="${sessionScope.messageList}">
            <tr>
                <td><c:out value="${message.fromUser}"></c:out></td>
                <td><c:out value="${message.message}"></c:out></td>
                <td><a href="reply.htm?to=<c:out value="${message.fromUser}"/>&action=reply">Reply</a></td>
                <td><c:out value="${message.messageDate}"></c:out></td>
                <td><a href="">Delete</a></td>
            </tr>
        </c:forEach>
        </table>

    </h1>

</body>
</html>
