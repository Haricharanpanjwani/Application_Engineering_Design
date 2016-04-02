/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csv.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author hpanjwani
 */
public class DAO {
    
    private String driver;
    private String dburl;
    private String dbuser;
    private String dbpassword;
    
    public DAO() {
        
        driver = "com.mysql.jdbc.Driver";
        dburl = "jdbc:mysql://localhost:3307/Assignment4Part4";
        dbuser = "root";
        dbpassword="";
        
        DbUtils.loadDriver(driver);
    
    }
    
    public Connection getConnection(){
        Connection conn =null;
        try{
            conn = DriverManager.getConnection(dburl,dbuser,dbpassword);
            
        }catch(SQLException ex){
            Logger.getLogger(SalesAddDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return conn;
    }
    
    public Connection getCsvConnection(){
        
        Connection conn =null;
        
        try{
            // Load the driver.
            Class.forName("org.relique.jdbc.csv.CsvDriver");
                
            // Create a connection. The first command line parameter is
            // the directory containing the .csv files.
            // A single connection is thread-safe for use by several threads.
            conn = DriverManager.getConnection("jdbc:relique:csv:/Users/hpanjwani/Downloads/");            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return conn;
    }
    
    public void close(Connection connection){
        if(connection != null){
            try{
                DbUtils.close(connection);
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }     

    
}
