<%-- 
    Document   : PageMenu
    Created on : Feb 26, 2016, 5:36:47 PM
    Author     : hpanjwani
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
<style>
ul.pagination {
    display: inline-block;
    padding: 0;
    margin: 0;
}

ul.pagination li {display: inline;}

ul.pagination li a {
    color: black;
    float: left;
    padding: 8px 16px;
    text-decoration: none;
    transition: background-color .3s;
    border: 1px solid #ddd;
}

ul.pagination li a.active {
    background-color: #4CAF50;
    color: white;
    border: 1px solid #4CAF50;
}

ul.pagination li a:hover:not(.active) {background-color: #ddd;}

div.center {text-align: center;}
</style>
</head>
<body>

<div class="center">
            <ul class="pagination">
                <c:set var="filename" value="${sessionScope.filename}"/>
                <c:set var="currentPage" value="${sessionScope.currentPage}"/>
                <c:if test="${currentPage != 1}">
                    <li><a href="csvdata.htm?action=display&page=${currentPage - 1}&filename=${filename}"> « </a> </li>
                </c:if>

                <%--For displaying Page numbers. 
                The when condition does not display a link for the current page--%>
                <c:set var="z" value="${sessionScope.currentPage}"/>
                <c:if test="${sessionScope.noOfPages - z gt 10 || sessionScope.noOfPages - z eq 10 }">
                    <c:forEach begin="1" end="10" var="i">
                        <li><a href="csvdata.htm?action=display&page=${z}&filename=${filename}">${z}</a></li>
                        <c:set var="z" value="${z+1}"/>
                    </c:forEach>
                </c:if>
                
                <c:if test="${sessionScope.noOfPages - z lt 10}">
                    <c:forEach begin="${z}" end="${sessionScope.noOfPages}" var="i">
                        <li><a href="csvdata.htm?action=display&page=${z}&filename=${filename}">${z}</a></li>
                        <c:set var="z" value="${z+1}"/>
                    </c:forEach>
                </c:if>

                <%--For displaying Next link --%>
                <c:if test="${sessionScope.noOfPages - currentPage gt 10 || sessionScope.noOfPages - currentPage eq 10 }">
                    <li><a href="csvdata.htm?action=display&page=${z}&filename=${filename}">»</a></li>
                </c:if>
            </ul>
           </div>

</body>


