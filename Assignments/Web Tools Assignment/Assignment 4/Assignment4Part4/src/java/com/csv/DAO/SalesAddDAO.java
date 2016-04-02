/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csv.DAO;

import com.csv.POJO.SaleDetail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author hpanjwani
 */
public class SalesAddDAO extends DAO {
    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public int addSale(ArrayList<SaleDetail> saleList) throws SQLException {
        
        int count = 0;
        int insert = 0;

        try {
            conn = getConnection();
            
            // Create SQL statement
            String query ="insert into saleDetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            // Create PrepareStatement object
            ps = conn.prepareStatement(query);

            //Set auto-commit to false
            conn.setAutoCommit(false);
            
            for(int i=0; i < saleList.size(); i++) {                
                ps.setInt(1, saleList.get(i).getSalesOrderID());
                ps.setInt(2, saleList.get(i).getRevisionNumber());
                ps.setString(3, saleList.get(i).getOrderDate());
                ps.setString(4, saleList.get(i).getDueDate());
                ps.setString(5, saleList.get(i).getShipDate());
                ps.setInt(6, saleList.get(i).getStatus());
                ps.setString(7, saleList.get(i).getOnlineOrderFlag());
                ps.setString(8, saleList.get(i).getSalesOrderNumber());
                ps.setString(9, saleList.get(i).getPurchaseOrderNumber());
                ps.setString(10, saleList.get(i).getAccountNumber());
                ps.setInt(11, saleList.get(i).getCustomerID());
                ps.setInt(12, saleList.get(i).getSalesPersonID());
                ps.setInt(13, saleList.get(i).getTerritoryID());
                ps.setInt(14, saleList.get(i).getBillToAddressID());
                ps.setInt(15, saleList.get(i).getShipToAddressID());
                ps.setInt(16, saleList.get(i).getShipMethodID());
                ps.setInt(17, saleList.get(i).getCreditCardID());
                ps.setString(18, saleList.get(i).getCreditCardApprovalCode());
                ps.setString(19, saleList.get(i).getCurrencyRateID());
                ps.setFloat(20, saleList.get(i).getSubTotal());
                ps.setFloat(21, saleList.get(i).getTaxAmt());
                ps.setFloat(22, saleList.get(i).getFreight());
                ps.setString(23, saleList.get(i).getTotalDue());
                ps.setString(24, saleList.get(i).getComment());
                ps.setString(25, saleList.get(i).getModifiedDate());
                ps.addBatch();
                count++;
            }
            
            if(count % 1000 == 0) {
                int[] counter = ps.executeBatch();
                insert = insert + count;
            }
            
            int[] counter = ps.executeBatch();
            insert = insert+count;

            //Explicitly commit statements to apply changes
            conn.commit();
            
            //int result = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SalesAddDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();
            //rs.close();
        }

        return insert;
    }
}
