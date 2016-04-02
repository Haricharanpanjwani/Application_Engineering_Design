<%-- 
    Document   : registrationview
    Created on : Feb 17, 2016, 10:56:17 PM
    Author     : yash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration Form</title>
    </head>
    <body>
        <spring:form method="POST" commandName="user"  enctype="multipart/form-data">
            
          First: <spring:input path="first" type="text" />
          <spring:errors cssStyle="color:red" path="first"/> <br><br>
            
             Last: <spring:input path="last" type="text" /> 
		<spring:errors cssStyle="color:red" path="last" /> <br><br>
                
                Gender:
                <spring:radiobutton path="gender" value="M"/>Male 
                <spring:radiobutton path="gender" value="F"/>Female 
                <spring:errors cssStyle="color:red" path="gender" /> <br><br>
                
                 Email: <spring:input path="email" type="text" /> 
		<spring:errors cssStyle="color:red" path="email" /> <br><br>
                
                About Me: <spring:textarea path="aboutMe"/>
                <spring:errors cssStyle="color:red" path="aboutMe"/> <br><br>
                
                Select Photo (Max Size: 5MB): <spring:input path="photo" type="file"/>
                <spring:errors cssStyle="color:red" path="photo"/> <br><br>
                
                <input type="submit" name="Register User"/>
            
        </spring:form>
    </body>
</html>
