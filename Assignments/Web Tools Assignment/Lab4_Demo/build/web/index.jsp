<%-- 
    Document   : index
    Created on : 6 Feb, 2016, 1:34:48 PM
    Author     : Kiran
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Lab4</h1>
        <c:if test="${!empty param.error}">
            <p style="color:red;"> Please enter valid credentials and login </p>
        </c:if>

        <c:choose>
            <c:when test="${!empty sessionScope.userName}">
                <c:redirect url="Login.htm?action=login"></c:redirect>                    
            </c:when>
            <c:otherwise>
                <form action='Login.htm' method='post'>
                    UserName : <input type ='text' name ='userName' 
                                      value='${cookie.userName.value}'><br /><br />
                    Password : <input type ='password' name ='password' 
                                      value='${cookie.password.value}'><br /><br />
                    <input type='checkbox' name='rememberMe' value="rememberMe"> 
                    Remember Me <br /><br />
                    <input type="submit" value="Submit"> 
                    <input type="hidden" name="action" value="login" />
                </form>                   
            </c:otherwise>
        </c:choose>
    </body>
</html>
