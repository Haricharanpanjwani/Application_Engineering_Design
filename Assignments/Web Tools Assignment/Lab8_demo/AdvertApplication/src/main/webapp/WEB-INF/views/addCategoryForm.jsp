<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Add Category Form</title>
</head>
<body>

<h2>Add a New Category</h2>

<form:form action="addcategory.htm" commandName="category" method="post">

<table>
<tr>
    <td>Category Title:</td>
    <td><form:input path="title" size="30" /> <font color="red"><form:errors path="title"/></font></td>
</tr>

<tr>
    <td colspan="2"><input type="submit" value="Create Category" /></td>
</tr>
</table>

</form:form>

</body>
</html>