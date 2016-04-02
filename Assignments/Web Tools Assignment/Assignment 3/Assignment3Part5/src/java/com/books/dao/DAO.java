/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.books.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hpanjwani
 */
public class DAO {
 
    public static Connection getConnectionJDBC(String dburl, String dbuser,String dbpassword, String dbdriver) throws IOException {
        Connection connection = null;
        try {
            Class.forName(dbdriver);
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
        }
        try {
            connection = DriverManager.getConnection(dburl,dbuser,dbpassword);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
        }

        if (connection != null) {
            System.out.println("connection established");
        }
        
        return connection;
    }
}
