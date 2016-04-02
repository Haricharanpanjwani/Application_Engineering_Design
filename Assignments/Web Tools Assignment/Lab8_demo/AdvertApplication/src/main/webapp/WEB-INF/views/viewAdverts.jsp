<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>ADVERT TITLE</b></td>
                <td><b>MESSAGE</b></td>
            </tr>
            <c:forEach var="adv" items="${adverts}">
                <tr>
                    <td>${adv.title}</td>
                    <td>${adv.message}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>