<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
//get the category list
        com.yusuf.spring.dao.CategoryDAO categorydao = new com.yusuf.spring.dao.CategoryDAO();
        java.util.List categoryList = categorydao.list();
        pageContext.setAttribute("categories", categoryList);
%>

<html>
    <head>
        <title>Add Advert Form</title>
    </head>
    <body>

        <h2>Posting a New Advert</h2>

        <form:form action="addadvert.htm" commandName="advert" method="post">

            <table>

                <tr>
                    <td>Category:</td>
                    <td>
                        <form:select path="category_name">
                            <c:forEach var="categ" items="${categories}">
                                <form:option value="${categ.title}"/>
                            </c:forEach>
                        </form:select>
                    </td>
                </tr>

                <tr>
                    <td>Advert Title:</td>
                    <td><form:input path="title" size="30" /> <font color="red"><form:errors path="title"/></font></td>
                </tr>

                <tr>
                    <td>Message:</td>
                    <td><form:input path="message" size="30" /> <font color="red"><form:errors path="message"/></font></td>
                </tr>

                <tr>
                    <td>Advert Posted By:</td>
                    <td><form:input path="postedBy" size="30" /> <font color="red"><form:errors path="postedBy"/></font></td>
                </tr>

                <tr>
                    <td colspan="2"><input type="submit" value="Post Advert" /></td>
                </tr>
            </table>

        </form:form>

    </body>
</html>