package com.intuit.quickbase.devint;

import java.sql.*;

/**
 * This DBManager implementation provides a connection to the database containing population data.
 *
 * Created by ckeswani on 9/16/15.
 */
public class DBManagerImpl implements DBManager {
    
    public Connection getConnection() {
        
        Connection c = null;
        Statement stmt = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:resources/data/citystatecountry.db");
            System.out.println("Opened database successfully");

        } catch (ClassNotFoundException cnf) {
            System.out.println("could not load driver");
        } catch (SQLException sqle) {
            System.out.println("sql exception:" + sqle.getStackTrace());
        }
        return c;
    }
    
    // Adding the code for closing the connection
    public void close(Connection c){
        if(c != null){
            try{
                c.close();
            }
            catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    } 
    
    //TODO: Add a method (signature of your choosing) to query the db for population data by country

}
