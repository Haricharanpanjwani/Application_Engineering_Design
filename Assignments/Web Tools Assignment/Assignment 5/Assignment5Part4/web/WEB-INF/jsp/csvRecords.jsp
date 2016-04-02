<%-- 
    Document   : csvRecords
    Created on : Feb 26, 2016, 6:01:31 PM
    Author     : hpanjwani
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            table, td, th {    
                border: 1px solid #ddd;
                text-align: left;
            }

            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                padding: 15px;
            }

            ul.pagination {
                display: inline-block;
                padding: 0;
                margin: 0;
            }

            ul.pagination li {display: inline;}

            ul.pagination li a {
                color: black;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
                transition: background-color .3s;
                border: 1px solid #ddd;
            }

            ul.pagination li a.active {
                background-color: #4CAF50;
                color: white;
                border: 1px solid #4CAF50;
            }

            ul.pagination li a:hover:not(.active) {background-color: #ddd;}

            div.center {text-align: center;}
            
        </style>
        <title>Records</title>
    </head>
    <body>
       
        <table id="myTable">
            <tr>
                <th style="text-align: left;">SalesOrderID</th>
                <th style="text-align: left;">RevisionNumber</th>
                <th style="text-align: left;">OrderDate</th>
                <th style="text-align: left;">DueDate</th>
                <th style="text-align: left;">ShipDate</th>
                <th style="text-align: left;">Status</th>
                <th style="text-align: left;">OnlineOrderFlag</th>
                <th style="text-align: left;">SalesOrderNumber</th>
                <th style="text-align: left;">PurchaseOrderNumber</th>
                <th style="text-align: left;">AccountNumber</th>
                <th style="text-align: left;">CustomerID</th>
                <th style="text-align: left;">SalesPersonID</th>
                <th style="text-align: left;">TerritoryID</th>
                <th style="text-align: left;">BillToAddressID</th>
                <th style="text-align: left;">ShipToAddressID</th>
                <th style="text-align: left;">ShipMethodID</th>
                <th style="text-align: left;">CreditCardID</th>
                <th style="text-align: left;">CreditCardApprovalCode</th>
                <th style="text-align: left;">CurrencyRateID</th>
                <th style="text-align: left;">SubTotal</th>
                <th style="text-align: left;">TaxAmt</th>
                <th style="text-align: left;">Freight</th>
                <th style="text-align: left;">TotalDue</th>
                <th style="text-align: left;">Comment</th>
                <th style="text-align: left;">ModifiedDate</th>
            </tr>  

            <c:set var="index" value="${1}"/>
            <c:forEach var="s" items="${sessionScope.salesList}">

                <div>
                    <tr id="rowNo${index}" >
                    
                            <form id="myForm" method="POST" enctype="multipart/form-data">
                            <td><input type="text" id="salesOrderId${index}" value="${s.salesOrderId}"/> </td>
                            <td><input type="text" id="revisionNumber${index}" value="${s.revisionNumber}"/></td>
                            <td><input type="text" id="orderDate${index}" value="${s.orderDate}"/> </td>
                            <td><input type="text" id="dueDate${index}" value="${s.dueDate}"/> </td>
                            <td><input type="text" id="shipDate${index}" value="${s.shipDate}"/> </td>
                            <td><input type="text" id="status${index}" value="${s.status}"/> </td>
                            <td><input type="text" id="onlineOrderFlag${index}" value="${s.onlineOrderFlag}"/> </td>
                            <td><input type="text" id="salesOrderNumber${index}" value="${s.salesOrderNumber}"/> </td>
                            <td><input type="text" id="purchaseOrderNumber${index}" value="${s.purchaseOrderNumber}"/> </td>
                            <td><input type="text" id="accountNumber${index}" value="${s.accountNumber}"/> </td>
                            <td><input type="text" id="customerId${index}" value="${s.customerId}"/> </td>
                            <td><input type="text" id="salesPersonId${index}" value="${s.salesPersonId}"/> </td>
                            <td><input type="text" id="territoryId${index}" value="${s.territoryId}"/> </td>
                            <td><input type="text" id="billToAddressId${index}" value="${s.billToAddressId}"/> </td>
                            <td><input type="text" id="shipToAddressId${index}" value="${s.shipToAddressId}"/> </td>
                            <td><input type="text" id="shipMethodId${index}" value="${s.shipMethodId}"/> </td>
                            <td><input type="text" id="creditCardId${index}" value="${s.creditCardId}"/> </td>
                            <td><input type="text" id="creditCardApprovalCode${index}" value="${s.creditCardApprovalCode}"/> </td>
                            <td><input type="text" id="currencyRateId${index}" value="${s.currencyRateId}"/> </td>
                            <td><input type="text" id="subTotal${index}" value="${s.subTotal}"/> </td>
                            <td><input type="text" id="taxAmt${index}" value="${s.taxAmt}"/> </td>
                            <td><input type="text" id="freight${index}" value="${s.freight}"/> </td>
                            <td><input type="text" id="totalDue${index}" value="${s.totalDue}"/> </td>
                            <td><input type="text" id="comment${index}" value="${s.comment}"/> </td>
                            <td><input type="text" id="modifiedDate${index}" value="${s.modifiedDate}"/> </td>
                            <input type="hidden" id="rowNo${index}" value="${index}">
                            <td><input type="submit" id="submit${index}" value="Save" onclick="return saveDetails(${index});" /> </td>
                            <td><input type="button" value="Delete" onclick="javascript:deleteRow(this); return false;"/> </td>
                        </form>
                      
                    </tr>
                    </div> 
                    <c:set var="index" value="${index+1}"/>
         
            </c:forEach>

        </table><br/>
       
   <jsp:include page="PageMenu.jsp"></jsp:include>    
   
   <script>
       var xmlHttp;
        xmlHttp = GetXmlHttpObject();
        function saveDetails(rowNo,x) {

            if (xmlHttp == null)
            {
                alert("Your browser does not support AJAX!");
                return;
            }
            //var rowNo=document.getElementById("rowNo").value;
            var salesOrderId=document.getElementById("salesOrderId"+rowNo).value;
            var revisionNumber=document.getElementById("revisionNumber"+rowNo).value;
            var orderDate=document.getElementById("orderDate"+rowNo).value;
            var dueDate=document.getElementById("dueDate"+rowNo).value;
            var shipDate=document.getElementById("shipDate"+rowNo).value;
            var status=document.getElementById("status"+rowNo).value;
            var onlineOrderFlag=document.getElementById("onlineOrderFlag"+rowNo).value;
            var salesOrderNumber=document.getElementById("salesOrderNumber"+rowNo).value;
            var purchaseOrderNumber=document.getElementById("purchaseOrderNumber"+rowNo).value;
            var accountNumber=document.getElementById("accountNumber"+rowNo).value;
            var customerId=document.getElementById("customerId"+rowNo).value;
            var salesPersonId=document.getElementById("salesPersonId"+rowNo).value;
            var territoryId=document.getElementById("territoryId"+rowNo).value;
            var billToAddressId=document.getElementById("billToAddressId"+rowNo).value;
            var shipToAddressId=document.getElementById("shipToAddressId"+rowNo).value;
            var shipMethodId=document.getElementById("shipMethodId"+rowNo).value;
            var creditCardId=document.getElementById("creditCardId"+rowNo).value;
            var creditCardApprovalCode=document.getElementById("creditCardApprovalCode"+rowNo).value;
            var currencyRateId=document.getElementById("currencyRateId"+rowNo).value;
            var subTotal=document.getElementById("subTotal"+rowNo).value;
            var taxAmt=document.getElementById("taxAmt"+rowNo).value;
            var freight=document.getElementById("freight"+rowNo).value;
            var totalDue=document.getElementById("totalDue"+rowNo).value;
            var comment=document.getElementById("comment"+rowNo).value;
            var modifiedDate=document.getElementById("modifiedDate"+rowNo).value;

            var query = "action=save&salesOrderId=" + salesOrderId + "&revisionNumber=" + revisionNumber + "&orderDate=" + orderDate + "&dueDate=" + dueDate + "&shipDate=" + shipDate + "&status=" + status
            + "&onlineOrderFlag=" + onlineOrderFlag + "&salesOrderNumber=" + salesOrderNumber+ "&purchaseOrderNumber=" + purchaseOrderNumber+ "&accountNumber=" + accountNumber+ "&customerId=" + customerId
            + "&salesPersonId=" + salesPersonId+ "&territoryId=" + territoryId+ "&billToAddressId=" + billToAddressId+ "&shipToAddressId=" + shipToAddressId+ "&shipMethodId=" + shipMethodId+ "&creditCardId=" + creditCardId
    + "&creditCardApprovalCode=" + creditCardApprovalCode+ "&currencyRateId=" + currencyRateId + "&subTotal=" + subTotal+ "&taxAmt=" + taxAmt+ "&freight=" + freight+ "&totalDue=" + totalDue
    + "&comment=" + comment+ "&modifiedDate=" + modifiedDate;

            xmlHttp.onreadystatechange = function stateChanged()
            {
                if (xmlHttp.readyState == 4)
                {
                    //alert(xmlHttp.responseText);
                    var json = JSON.parse(xmlHttp.responseText);
                    //document.getElementById("success").innerHTML = json.successmsg;
                }
            };
            xmlHttp.open("POST", "add.htm", true);
            xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlHttp.send(query);
            var x = document.getElementById("rowNo"+rowNo);
            x.style.backgroundColor = "green";  
            document.getElementById("submit"+rowNo).value="Saved";
            document.getElementById("submit"+rowNo).disabled = true;
            return false;
        }

          
            var deleteRow = function (link) {
            var row = link.parentNode.parentNode;
            var table = row.parentNode; 
            table.removeChild(row); 
 }
        
        function GetXmlHttpObject()
        {
            var xmlHttp = null;
            try
            {
                // Firefox, Opera 8.0+, Safari
                xmlHttp = new XMLHttpRequest();
            } catch (e)
            {
                // Internet Explorer
                try
                {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e)
                {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
            }
            return xmlHttp;
        }
        
   </script> 
   
    </body>
</html>
