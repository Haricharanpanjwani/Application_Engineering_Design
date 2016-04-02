<%-- 
    Document   : CourseView
    Created on : Jan 29, 2016, 5:33:14 PM
    Author     : dishu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course View</title>
    </head>
    <body>
        <h3> Courses Added:</h3>
        <%
//        List<Course>courseList=new ArrayList<>();
//            courseList=(List<Course>)session.getAttribute("myCourseList");
//            for(Course course:courseList)
//            {
                HashSet<Course> myCourseSet=new HashSet<Course>();
                myCourseSet=(HashSet<Course>)session.getAttribute("myCourseList");
                Iterator iterator = myCourseSet.iterator();
                while (iterator.hasNext())
                { 
                    Course course=(Course)iterator.next();
                  String crn=course.getCrn();
                  String courseName=course.getName();
          %>  
        
        <h4> Crn </h4><jsp:expression>crn</jsp:expression> <h4> Course Name </h4>  <jsp:expression>courseName</jsp:expression>
        <a href='removeCourse.htm?action=remove&crn=<jsp:expression>crn</jsp:expression>'> Remove course </a>
            <jsp:scriptlet> } </jsp:scriptlet>
        <h4> 
            
            <!-- Using JSTL Tags -->
            <c:forEach items="${sessionScope.myCourseList}" var="item">
            CRN: ${item.crn} Course Name: ${item.name} <a href='removeCourse.htm?action=remove&crn=${item.crn}'> Remove course </a>
            </c:forEach>
            
    </body>
</html>
