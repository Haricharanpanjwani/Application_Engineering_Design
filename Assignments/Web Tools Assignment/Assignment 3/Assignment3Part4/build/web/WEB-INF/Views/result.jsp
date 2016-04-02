<%-- 
    Document   : result
    Created on : Feb 8, 2016, 4:49:29 PM
    Author     : hpanjwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>Search Result</title>
    </head>
    <body style='background: #e3f2fd;'>       
        <c:choose>
            <c:when test="${param.action == 'error'}">
                
                <div class="container contact_tot">
                    <div class="panel panel-default">
                        <div class="panel-heading">			       
                            <b> Error Message </b>
                        </div>
                    </div>
                </div>     

                <div class="form-group col-sm-12" align='center'>
                    <label><jsp:expression>request.getParameter("name")</jsp:expression> cannot be empty. </label>
                    <br />
                    <p>Go to Home page and try again!!</p>                
                </div>                        
            </c:when>
            
            
            <c:when test="${param.action == 'add'}">
                <h1>Movie is successfully added to the database!!</h1>                    
            </c:when>
       
            
        <c:otherwise>                
        <div class ='container'>
            
            <div class="container contact_tot">
                <div class="panel panel-default">
                    <div class="panel-heading">			       
                        <b>Search Results: </b>
                </div>
            </div>
        </div>       
                       
        <div class="form-group col-sm-6">
            <center><p>You have searched for "<label><jsp:expression>request.getAttribute("search")</jsp:expression></label>"</p>
        
        <br />
        <br />
        
            <h4>Here are the search results</h4>
        </div>
        
        <table border='1' class='table table-hover'>
            <thead>
            <tr>
                <th>Movie Title</th>
                <th>Lead Actor</th>
                <th>Lead Actress</th>
                <th>Genre</th>
                <th>Release Year</th>
            </tr>
            </thead>
            
            <tbody>
            <c:forEach var="movie" items="${sessionScope.movieList}">
                <tr>
                    <td><c:out value="${movie.movieTitle}"></c:out></td>
                    <td><c:out value="${movie.leadActor}"></c:out></td>
                    <td><c:out value="${movie.leadActress}"></c:out></td>
                    <td><c:out value="${movie.genre}"></c:out></td>                                
                    <td><c:out value="${movie.year}"></c:out></td>
                </tr>
            </c:forEach>
            </tbody>    
            
        </table>                               
        
        </div>            
        </c:otherwise>      
        </c:choose>
        <div class="form-group col-sm-6">
            <center><a href='index.jsp'>Click here to go back to Home Page</a></center>
        </div>  
            
    </body>
</html>