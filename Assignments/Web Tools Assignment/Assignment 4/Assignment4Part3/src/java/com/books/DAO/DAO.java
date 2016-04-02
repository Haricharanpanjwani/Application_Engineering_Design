/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.books.DAO;

import java.io.IOException;
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
    
    public DAO(){
        driver = "com.mysql.jdbc.Driver";
        dburl = "jdbc:mysql://localhost:3307/booksdb";
        dbuser = "root";
        dbpassword="";
        
        DbUtils.loadDriver(driver);
    }
    
    public Connection getConnection(){
        Connection conn =null;
        try{
            conn = DriverManager.getConnection(dburl,dbuser,dbpassword);
            
        }catch(SQLException ex){
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,null,ex);
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
    
//    public static Connection getConnectionJDBC() throws IOException {                
//        
//        String dburl = getServletContext().getInitParameter("dburl");
//        String dbuser = getServletContext().getInitParameter("dbuser");
//        String dbpassword = getServletContext().getInitParameter("dbpassword");
//        String dbdriver = getServletContext().getInitParameter("dbdriver");
//        
//        Connection connection = null;
//        
//        try {
//            Class.forName(dbdriver);
//        } catch (ClassNotFoundException e) {
//            System.out.println("Where is your MySQL JDBC Driver?");
//        }
//        try {
//            connection = DriverManager.getConnection(dburl,dbuser,dbpassword);
//        } catch (SQLException e) {
//            System.out.println("Connection Failed! Check output console");
//        }
//
//        if (connection != null) {
//            System.out.println("connection established");
//        }
//        
//        return connection;
//    }
}
