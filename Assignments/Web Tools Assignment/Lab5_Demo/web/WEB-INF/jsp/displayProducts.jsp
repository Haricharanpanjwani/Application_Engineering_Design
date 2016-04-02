<%-- 
    Document   : displayProducts
    Created on : Feb 11, 2016, 7:06:31 PM
    Author     : kumaran_jay
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${!empty sessionScope.customerId}">
                <jsp:include page="menu.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:include page="menu2.jsp"/>
            </c:otherwise>
        </c:choose>
        <h2>Our product catalog</h2>
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th></th>
            </tr>
            <c:forEach var="product" items="${requestScope.productList}">
                <tr>
                    <td>${product.productName}</td>
                    <td>${product.description}</td>
                    <td>$${product.price}</td>
                    <td><a href="addtocart.htm?id=${product.productID}&action=addtocart">Add to Cart</a></td>
                </tr>   
            </c:forEach>
        </table>
    </body>
</html>
