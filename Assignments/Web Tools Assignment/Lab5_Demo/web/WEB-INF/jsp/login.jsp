<%-- 
    Document   : login
    Created on : Feb 11, 2016, 11:16:36 PM
    Author     : kumaran_jay
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <h1>Log in</h1>
        <form action="login.htm" method="post">
            Username : <input type="text" name="username"><br/>
            Password : <input type="password" name="password"><br/>
            <input type="submit" value="Login"><br/>
            <input type="hidden" name="action" value="login">
            <c:if test="${!empty requestScope.error}">
                <p style="color:red">Invalid credentials</p>
            </c:if>
        </form>
    </body>
</html>
