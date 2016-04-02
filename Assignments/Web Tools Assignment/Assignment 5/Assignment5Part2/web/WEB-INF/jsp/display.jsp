<%-- 
    Document   : display
    Created on : Feb 17, 2016, 10:02:06 AM
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
        <title>Display Result</title>        
    </head>
    <body style='background: #e3f2fd;'>   
        
        <div class='container'>
            
        <c:choose>
            <c:when test="${requestScope.action == 'empty'}">
                
                <div class="container contact_tot">
                    <div class="panel panel-default">
                        <div class="panel-heading">			       
                            <b> Error Message </b>
                        </div>
                    </div>
                </div>     

                <div class="form-group col-sm-12" align='center'>
                    <label>Number of Books cannot be empty. </label>
                    <br />
                    <p>Go to Home page and try again!!</p>                
                </div>                        
            </c:when> 
            
            <c:when test="${requestScope.action == 'numberFormat'}">
                
                <div class="container contact_tot">
                    <div class="panel panel-default">
                        <div class="panel-heading">			       
                            <b> Error Message </b>
                        </div>
                    </div>
                </div>     

                <div class="form-group col-sm-12" align='center'>
                    <label>Fields cannot be empty. </label>
                    <br />
                    <p>Go to Home page and try again!!</p>                
                </div>                        
            </c:when> 
                    
            <c:otherwise> 
                
                    <div class="container contact_tot">
                    <div class="panel panel-default">
                        <div class="panel-heading">			       
                            <b> Success Message </b>
                        </div>
                    </div>
                </div> 
                
                <div class="form-group col-sm-12" align='center'>
                    <h3><jsp:expression>session.getAttribute("numberOfBooks")</jsp:expression> Book is successfully added to the database!!</h3>                    
                </div>
            </c:otherwise>
        </c:choose>
        
        <div class="form-group col-sm-12" align='center'>
            <a href='index.htm'>Click here to go back to Home Page</a>
        </div>
            
        </div>          
    </body>
</html>
