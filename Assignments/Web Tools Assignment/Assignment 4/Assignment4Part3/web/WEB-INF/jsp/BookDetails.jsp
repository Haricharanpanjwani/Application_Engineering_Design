<%-- 
    Document   : test
    Created on : Feb 16, 2016, 11:16:04 PM
    Author     : hpanjwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>Form Book Details</title>
    </head>
    <body style='background: #e3f2fd;'>
        
        <c:if test="${!empty requestScope.numberOfBooks}">        
        
            <div class=''container>
        <form role='form' method='POST' action='addBook.htm'>
            
                    <div class="container contact_tot">
                    <div class="panel panel-default">
                        <div class="panel-heading">			       
                            <b> Enter Book Details:  </b>
                        </div>
                    </div>
                </div> 
            <div class='container' align='center'>
                <h4>Number of Books to be added: <c:out value="${requestScope.numberOfBooks}" /></h4>

                <table border='1' width=100% class='table table-hover'>
                    <thead>
                    <tr>
                        <th>ISBN</th>
                        <th>Book Title</th>
                        <th>Authors</th>
                        <th>Price</th>                    
                    </tr>
                    </thead>

                    <tbody>        
                    <c:forEach var='i' begin="1" end="${requestScope.numberOfBooks}" step="1">
                        <tr>            
                            <td><input type="text" name="isbn${i}"   Placeholder='ISBN' class="form-control" /></td>
                            <td><input type="text" name="title${i}"  Placeholder='Name of Book' class="form-control" /></td>
                            <td><input type="text" name="author${i}" Placeholder='Name of Author' class="form-control" /></td>
                            <td><input type="number" name="price${i}"  Placeholder='Price of Book' class="form-control" /></td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>

                <div class="form-group col-sm-12">
                    <center><input type="submit" class="btn btn-primary btn-md" value='Add Books' /></center>
                </div>
                
                <div class="form-group col-sm-12">
                    <center><input type="hidden" name="action" value="display"class="btn btn-primary btn-md" /></center>
                </div>
            </div>        
        </form>
        </div>
        </c:if>
    </body>
</html>
