/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.DAO;

import com.sales.bean.SaleBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author hpanjwani
 */
public class SalesReadDAO extends DAO {
        
    Connection conn;   
    PreparedStatement ps;
    List<SaleBean> saleDetailsList = new ArrayList<SaleBean>();
        
    public List<SaleBean> getAllSaleDetails(String filename) {                                
        
        try {                           
            
            conn = getCsvConnection();
            
            String querySearch = "SELECT * FROM " + filename;            
            
            ps = conn.prepareStatement(querySearch);            
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                
                SaleBean sd = new SaleBean();
                
                int salesOrderID = rs.getInt("SalesOrderID");                
                int revisionNumber = rs.getInt("RevisionNumber");
                String orderDate = rs.getString("OrderDate");
                String dueDate = rs.getString("DueDate");
                String shipDate = rs.getString("ShipDate");
                int status = rs.getInt("Status");
                String onlineOrderFlag = rs.getString("OnlineOrderFlag");
                String salesOrderNumber = rs.getString("SalesOrderNumber");
                String purchaseOrderNumber = rs.getString("PurchaseOrderNumber");
                String accountNumber = rs.getString("AccountNumber");
                int customerID = rs.getInt("CustomerID");	
                int salesPersonID = rs.getInt("SalesPersonID");
                int territoryID = rs.getInt("TerritoryID");
                int billToAddressID = rs.getInt("BillToAddressID");
                int shipToAddressID = rs.getInt("ShipToAddressID");
                int shipMethodID =  rs.getInt("ShipMethodID");
                int creditCardID = rs.getInt("CreditCardID");
                String creditCardApprovalCode = rs.getString("CreditCardApprovalCode");
                String currencyRateID = rs.getString("CurrencyRateID");
                float subTotal = rs.getFloat("SubTotal");
                float taxAmt = rs.getFloat("TaxAmt");
                float freight = rs.getFloat("Freight");
                String totalDue = rs.getString("TotalDue");
                String comment = rs.getString("Comment");
                String modifiedDate = rs.getString("ModifiedDate");                
                
                sd.setSalesOrderID(salesOrderID);
                sd.setRevisionNumber(revisionNumber);
                sd.setOrderDate(orderDate);
                sd.setDueDate(dueDate);
                sd.setShipDate(shipDate);
                sd.setStatus(status);
                sd.setOnlineOrderFlag(onlineOrderFlag);
                sd.setSalesOrderNumber(salesOrderNumber);
                sd.setPurchaseOrderNumber(purchaseOrderNumber);
                sd.setAccountNumber(accountNumber);
                sd.setCustomerID(customerID);
                sd.setSalesPersonID(salesPersonID);
                sd.setTerritoryID(territoryID);
                sd.setBillToAddressID(billToAddressID);
                sd.setShipToAddressID(shipToAddressID);
                sd.setShipMethodID(shipMethodID);
                sd.setCreditCardID(creditCardID);
                sd.setCreditCardApprovalCode(creditCardApprovalCode);
                sd.setCurrencyRateID(currencyRateID);
                sd.setSubTotal(subTotal);
                sd.setTaxAmt(taxAmt);
                sd.setFreight(freight);
                sd.setTotalDue(totalDue);
                sd.setComment(comment);
                sd.setModifiedDate(modifiedDate);
                sd.setOrderDate(orderDate);                
                
                saleDetailsList.add(sd);
            }
            
            // Dump out the results to a CSV file with the same format
            // using CsvJdbc helper function
            //boolean append = true;
            //ResultSetHandler<List<SaleDetail>> resultSetHandler = new BeanListHandler<SaleDetail>(SaleDetail.class);
            //CsvDriver.writeToCsv(rs, System.out, append);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close(conn);
        }
        
        return saleDetailsList;
    }    
}
