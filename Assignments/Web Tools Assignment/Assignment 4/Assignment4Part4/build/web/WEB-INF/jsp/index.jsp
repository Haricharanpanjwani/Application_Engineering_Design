<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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
           
        <c:when test='${!empty sessionScope.numberOfRows}'>
            
            <div class="container contact_tot">
                <div class="panel panel-default">
                    <div class="panel-heading">			       
                        <b> Success Message </b>
                    </div>
                </div>
            </div>
            
            <div class="form-group col-sm-12" align='center'>
                <h3><jsp:expression>session.getAttribute("numberOfRows")</jsp:expression> rows are successfully added to the database </h3>
            </div>
            
            <div class="form-group col-sm-12">
                <center><a href='index.htm'>Click here to go to Home Page</a></center>
            </div>
            
        </c:when>
                
            
        <c:when test='${!empty sessionScope.saleList}'>
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
                <input type='hidden' value='dbConnection' name='action' />
                <input type='submit' value='Add to Database' name='Submit' />                                        
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
                
                <c:forEach var="sale" items="${requestScope.saleList}">
                    <tr>            
                        <td><input type='text' name='saleOrderID' value='${sale.salesOrderID}' /></td>
                        <td><input type='text' name='revisionNumber' value='${sale.revisionNumber}' /></td>
                        <td><input type='text' name='orderDate' value='${sale.orderDate}' /></td>     
                        <td><input type='text' name='dueDate' value='${sale.dueDate}' /></td>
                        <td><input type='text' name='shipDate' value='${sale.shipDate}' /></td>
                        <td><input type='text' name='status' value='${sale.status}' /></td>
                        <td><input type='text' name='onlineOrderFlag' value='${sale.onlineOrderFlag}' /></td>
                        <td><input type='text' name='salesOrderNumber' value='${sale.salesOrderNumber}' /></td>
                        <td><input type='text' name='purchaseOrderNumber' value='${sale.purchaseOrderNumber}' /></td>
                        <td><input type='text' name='accountNumber' value='${sale.accountNumber}' /></td>
                        <td><input type='text' name='customerID' value='${sale.customerID}' /></td>
                        <td><input type='text' name='salesPersonID' value='${sale.salesPersonID}' /></td>
                        <td><input type='text' name='territoryID' value='${sale.territoryID}' /></td>
                        <td><input type='text' name='billToAddressID' value='${sale.billToAddressID}' /></td>
                        <td><input type='text' name='shipToAddressID' value='${sale.shipToAddressID}' /></td>
                        <td><input type='text' name='shipMethodID' value='${sale.shipMethodID}' /></td>
                        <td><input type='text' name='creditCardID' value='${sale.creditCardID}' /></td>
                        <td><input type='text' name='creditCardApprovalCode' value='${sale.creditCardApprovalCode}' /></td>
                        <td><input type='text' name='currencyRateID' value='${sale.currencyRateID}' /></td>
                        <td><input type='text' name='subTotal' value='${sale.subTotal}' /></td>
                        <td><input type='text' name='taxAmt' value='${sale.taxAmt}' /></td>
                        <td><input type='text' name='freight' value='${sale.freight}' /></td>
                        <td><input type='text' name='totalDue' value='${sale.totalDue}' /></td>
                        <td><input type='text' name='comment' value='${sale.comment}' /></td>
                        <td><input type='text' name='modifiedDate' value='${sale.modifiedDate}' /></td>
                    </tr>   
                </c:forEach>
            </table>
            </form>
        </div>
            
        </c:when>
                
        <c:otherwise>                
            
            <div class="bg-primary text-center">
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
        
</html>
