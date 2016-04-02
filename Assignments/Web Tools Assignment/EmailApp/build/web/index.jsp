<%-- 
    Document   : index
    Created on : Feb 6, 2016, 10:21:49 AM
    Author     : hpanjwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Email Login</title>
    </head>
    <body>        
        <div style="text-align: center">
            <h2>Please Login!</h2>
            
            <c:choose>
                <c:when test="${!empty sessionScope.userName}">
                    <c:redirect url="login.htm?action=login"></c:redirect>
                </c:when>
            </c:choose>
            
            <c:if test = "${!empty param.error}">
                <p style="color:red"> Please enter valid credentials and login</p>
            </c:if>
                            
            <form method='POST' action='login.htm'>
                Username: <input type="text" name = "userName" placeholder ="Username" value='${cookie.userName.value}'/><br /><br />                    
                Password: <input type="password" name="password" placeholder="Password" value='${cookie.password.value}'/><br /><br />
                <input type="checkbox" name="rememberMe" value="rememberMe">Remember Me<br /><br />
                <input type="submit" value="Submit" />
                <input type="hidden" name="action" value="login" />
                    
                <a href ="#" name="SignUp">SIGN UP</a>
            </form>      
        </div>
    </body>
</html>
