<%-- 
    Document   : addBooks
    Created on : Feb 8, 2016, 5:50:58 PM
    Author     : hpanjwani
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter Book details</title>
    </head>
    <body>
        <form action="insertBook.htm?action=insert" method="post"> 
         <table>
            <tr>
                <th style="text-align: left;">ISBN</th>
                <th style="text-align: left;">Book Title</th>
                <th style="text-align: left;">Authors</th>
                <th style="text-align: left;">Price</th>
            </tr>  
            <c:set var="count" value="${sessionScope.noOfBooks}"/>
            <c:set var="index" value="${1}"/>
            <c:forEach begin="${1}" end="${count}" step="${1}">
                    <tr>
                    <td><input type="text" name="isbn${index}"/> </td>
                    <td><input type="text" name="title${index}"/> </td>
                    <td><input type="text" name="authors${index}"/> </td>
                    <td><input type="text" name="price${index}"/> </td>
                    </tr>
             <c:set var="index" value="${index+1}"/>
            </c:forEach>
        </table><br/>
        <input type="hidden" name="count" value="${count}">
        <input type="submit" value='Add Books'/> 
        </form>
    </body>
</html>
