<%-- 
    Document   : search
    Created on : Feb 18, 2016, 3:15:26 AM
    Author     : yash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search User</title>
    </head>
    <body>
        <form action="search.htm">
            
            Search User <input type="text" name="user" required /> <br><br>
            
            <label>Search By:</label>
            <input type="radio" name="searchkey" value="first" checked="checked"> First Name
            <input type="radio" name="searchkey" value="last"> Last Name
            <input type="radio" name="searchkey" value="gender"> Gender
            <input type="radio" name="searchkey" value="email"> Email <br><br>
            
            <input type="hidden" name="action" value="searchuser"/>
            <input type="submit" name="search"/>
        </form>
    </body>
</html>
