package com.intuit.quickbase.devint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ckeswani on 9/16/15.
 */
public interface DBManager {
    
    public Connection getConnection();
    
    //Added the close connection for database
    public void close(Connection c);
    
}
