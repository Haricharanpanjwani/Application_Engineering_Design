<%-- 
    Document   : searchresult
    Created on : Feb 18, 2016, 3:43:50 AM
    Author     : yash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Results</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${empty requestScope.userList}">
                <h3>No Users Found !</h3> 
                <p><a href="search.htm?action=showsearchform">Search Again</a></p>
                <p><a href="register.htm">New User Registration</a></p>
                
        </c:when>
        
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>First</th>
                    <th>Last</th>
                    <th>Email</th>
                    <th>About Me</th>
                    <th>Photo</th>
                </tr>
             <c:forEach items="${requestScope.userList}" var="user">
                 <tr>
                     <td> ${user.first}</td>
            <td> ${user.last}</td>
            <td> ${user.email}</td>
            <td> ${user.aboutMe}</td>
           <td> <img height="150" width="150" src="${user.photoName}" /></td>
            </tr>
        </c:forEach>
            </table>
            <p><a href="search.htm?action=showsearchform">Search Again</a></p>
                <p><a href="register.htm">New User Registration</a></p>
        </c:otherwise>
       </c:choose>

       
    </body>
</html>
