<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
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

        <h1>Welcome to E-Store</h1>
        <ul>
            <li><a href="#">Search Products</a></li>
            <li><a href="product.htm?action=display">All Products</a></li>
            <li><a href="#">Electronics</a></li>
            <li><a href="#">Computer</a></li>
        </ul>
    </body>
</html>
