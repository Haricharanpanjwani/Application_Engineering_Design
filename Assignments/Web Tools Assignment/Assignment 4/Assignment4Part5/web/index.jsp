<%-- 
    Document   : index
    Created on : Feb 20, 2016, 8:39:22 PM
    Author     : hpanjwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/saleTagLibrary.tld" prefix="sale" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>CSV File Reading</title>
    </head>
    <body style='background: #e3f2fd;'>    
        
        <c:choose>
           
            <c:when test='${!empty numberOfRows}'>
                
                <div class="container contact_tot">
                    <div class="panel panel-default">
                        <div class="panel-heading">			       
                            <b> Success Message </b>
                        </div>
                    </div>
                </div>
            
                <div class="form-group col-sm-12" align='center'>
                    <h3><jsp:expression>request.getAttribute("numberOfRows")</jsp:expression> rows are successfully added to the database </h3>
                </div>

                <div class="form-group col-sm-12">
                    <center><a href='index.jsp'>Click here to go to Home Page</a></center>
                </div>
            
            </c:when>
           
            <c:when test="${!empty fileName}">
                <div class="container contact_tot">
                    <div class="panel panel-default">
                        <div class="panel-heading">			       
                            <b> Sale Records </b>
                        </div>
                    </div>
                </div>
      
                <div class="bg-primary text-center" align='center'>
                    <h3>Sale Details retrieved from CSV File</h3>
                </div>
        
                <div class ="container">
                    <form action="add.htm" method='post'>
                        
                        <div class="form-group" align="center">
                            <input type='hidden' value='addDB' name='action' />
                            <input type='submit' value='Add to Database' name='submit' />                                        
                        </div>
                        
                        <table border='1' width=100% class='table table-hover'>
                            <tr>
                                <th>Sales Order ID</th>
                                <th>Revision Number</th>
                                <th>Order Date</th>
                                <th>Due Date</th>
                                <th>Ship Date</th>
                                <th>Status</th>
                                <th>Online Order Flag</th>
                                <th>Sales Order Number</th>
                                <th>Purchase Order Number</th>
                                <th>Account Number</th>
                                <th>Customer ID</th>
                                <th>Sales Person ID</th>
                                <th>Territory ID</th>
                                <th>Bill Address ID</th>
                                <th>Ship Address ID</th>
                                <th>Ship Method ID</th>
                                <th>Credit Card ID</th>
                                <th>Credit Card Approval Code</th>
                                <th>Currency Rate ID</th>
                                <th>Sub Total</th>
                                <th>Tax Amount</th>
                                <th>Freight</th>
                                <th>Total Due</th>
                                <th>Comment</th>
                                <th>Modified Date</th>
                            </tr>
                            
                            <sale:saledetails file="${fileName}" saleList="${saleList}"/>
                            
                        </table>
                    </form>
                </div>
                    
            </c:when>
            
            <c:otherwise>
                
                <div class="bg-primary text-center" align="center">
                    <h2> Welcome to CSV File App </h2>
                </div>

                <div class='container'>                        
                    <form role='form' method='post' action='read.htm'>

                        <div class="form-group col-sm-6">
                            <label>Enter the name of the CSV file you want to read</label>
                            <input type="text" name="name" Placeholder="Enter the name of file" class="form-control" />                    
                        </div>                

                        <div class="form-group col-sm-12">
                            <input type="submit" name="submit" value="Submit" class="btn btn-primary btn-md" />
                        </div>

                        <div class="form-group col-sm-12">
                            <input type="hidden" name="action" value='displayForm' class="btn btn-primary btn-md" />
                        </div>
                    </form>
                </div>   
                
            </c:otherwise>
        </c:choose>
        
    </body>
</html>
