<%-- 
    Document   : signup
    Created on : Feb 11, 2016, 11:49:56 PM
    Author     : kumaran_jay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up</title>
    </head>
    <body>
        <h1>Sign up</h1>
        <form action="signup.htm?action=signup" method="post">
            <p>Name: <input type="text" name="name"></p>
            <p>City: <input type="text" name="city"></p>
            <p>Phone: <input type="text" name="number"></p>
            <p>Username: <input type="text" name="username"></p>
            <p>Password: <input type="password" name="password"></p>
            <input type="submit" value="Sign Up">
        </form>
    </body>
</html>
