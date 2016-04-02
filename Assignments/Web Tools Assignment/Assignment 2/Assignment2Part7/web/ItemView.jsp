<%-- 
    Document   : ItemView
    Created on : Feb 3, 2016, 2:29:37 AM
    Author     : hpanjwani
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@page import="Bean.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item View</title>
    </head>
    <body>
        <h3>Items Currently in your CART</h3>        
        <hr/>
        
        
        <%
            if(session.getAttribute("myItemList") == null ) {
        %>
        <h4> There is no item in the cart!! Please add few items!</h4>
        <hr/> 
        
        <%
            }
            else {       
               
                int i=1;                   
                double total = 0.00;
                
                HashSet<Item> myItemSet = new HashSet<Item>();                
                myItemSet = (HashSet<Item>)session.getAttribute("myItemList");
                
                Iterator iterator = myItemSet.iterator();                                
                
                while (iterator.hasNext())  { 
                  Item item = (Item)iterator.next();
                  String name = item.getItemName();
                  double price = item.getPrice();                                                   
                  
                  total = total + price;
          
          %>  
          
        <label><jsp:expression>i</jsp:expression>&nbsp;&nbsp;&nbsp;<jsp:expression>name</jsp:expression>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$<jsp:expression>price</jsp:expression> </label>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='removeItem.htm?action=remove&name=<jsp:expression>name</jsp:expression>'>[ Remove from cart ]</a>
        <br/><br/>                                        
            
        <jsp:scriptlet> i++; }</jsp:scriptlet>
        <hr />
        <h4><label>Total Cart Value</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$<jsp:expression>total</jsp:expression></h4>
        
        <!-- Using JSTL Tags -->
        <!--    <c:forEach items= "${sessionScope.myItemList}" var="item">
            ${item.itemName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.price}   <a href='removeItem.htm?action=remove&name=${item.itemName}'>[ Remove from cart ]</a>
            <br /><br />
            </c:forEach-->
        
        
        <jsp:scriptlet> } </jsp:scriptlet>   
        
    </body>
</html>
