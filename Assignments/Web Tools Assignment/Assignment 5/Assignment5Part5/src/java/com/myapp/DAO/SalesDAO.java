/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.DAO;

import configuration.Newsalesorder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author hpanjwani
 */
public class SalesDAO {
    
    Connection conn;
    PreparedStatement ps;
    ResultSet results;
    private int MAX_RECORDS_PER_PAGE;
    
    public ArrayList<Newsalesorder> getSalesListFromCSV(String fileName, int page) throws SQLException
    {
         ArrayList<Newsalesorder> salesList=new ArrayList<Newsalesorder>();
         MAX_RECORDS_PER_PAGE=100;
        try
        {
          // Load the driver.
          Class.forName("org.relique.jdbc.csv.CsvDriver");
         
            try ( 
                Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + "/Users/hpanjwani/Downloads/")) {
                String query = "SELECT SalesOrderID,RevisionNumber,OrderDate,DueDate,ShipDate,Status,OnlineOrderFlag,SalesOrderNumber,PurchaseOrderNumber,AccountNumber,CustomerID,SalesPersonID,\n" +
    "           TerritoryID,BillToAddressID,ShipToAddressID,ShipMethodID,CreditCardID,CreditCardApprovalCode,CurrencyRateID,SubTotal,TaxAmt,Freight,TotalDue,Comment,ModifiedDate FROM "+fileName+" LIMIT 100 OFFSET "+(MAX_RECORDS_PER_PAGE*(page-1));
                ps = conn.prepareStatement(query);
                results = ps.executeQuery();
            
             while(results.next())
            {
                Newsalesorder s= new Newsalesorder();
                s.setSalesOrderId(results.getString("SalesOrderID"));
                s.setRevisionNumber(results.getString("RevisionNumber"));
                s.setOrderDate(results.getString("OrderDate"));
                s.setDueDate(results.getString("DueDate"));
                s.setShipDate(results.getString("ShipDate"));
                s.setStatus(results.getString("Status"));
                s.setOnlineOrderFlag(results.getString("OnlineOrderFlag"));
                s.setSalesOrderNumber(results.getString("SalesOrderNumber"));
                s.setPurchaseOrderNumber(results.getString("PurchaseOrderNumber"));
                s.setAccountNumber(results.getString("AccountNumber"));
                s.setCustomerId(results.getString("CustomerID"));
                s.setSalesPersonId(results.getString("SalesPersonID"));
                s.setTerritoryId(results.getString("TerritoryID"));
                s.setBillToAddressId(results.getString("BillToAddressID"));
                s.setShipToAddressId(results.getString("ShipToAddressID"));
                s.setShipMethodId(results.getString("ShipMethodID"));
                s.setCreditCardId(results.getString("CreditCardID"));
                s.setCreditCardApprovalCode(results.getString("CreditCardApprovalCode"));
                s.setCurrencyRateId(results.getString("CurrencyRateID"));
                s.setSubTotal(results.getString("SubTotal"));
                s.setTaxAmt(results.getString("TaxAmt"));
                s.setFreight(results.getString("Freight"));
                s.setTotalDue(results.getString("TotalDue"));
                s.setComment(results.getString("Comment"));
                s.setModifiedDate(results.getString("ModifiedDate"));
                salesList.add(s);
            }
        
        return salesList;
            }
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
        
       return salesList;
    }
    
    public int getTotalCount(String fileName) throws SQLException
    {
         int records=0;
        try
        {
          // Load the driver.
          Class.forName("org.relique.jdbc.csv.CsvDriver");
         
            try ( 
                Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + "/Users/hpanjwani/Downloads/")) {
                String query = "SELECT COUNT(*) FROM "+fileName;
                ps = conn.prepareStatement(query);
                results = ps.executeQuery();
            
             while(results.next())
            {
                records=results.getInt(1);
            }
        
        return records;
            }
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
        
       return records;
    }
    
    public void addToDatabase(Newsalesorder s)
    {
        Configuration c = new Configuration();
        c.configure("/hibernate.cfg.xml");
        SessionFactory sf = c.buildSessionFactory();
        Session hibSession = sf.openSession();
        Transaction tx = hibSession.beginTransaction();
        try {
            hibSession.save(s);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            hibSession.close();
        }
    }
}
