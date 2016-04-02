/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.DAO;

import com.neu.edu.pojo.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kumaran_jay
 */
public class CustomerDAO extends DAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public int addCustomer(Customer customer) throws SQLException {

        int customerId = 0;

        try {
            conn = getConnection();
            String query ="insert into customer (username,password,name,city,phone) values(?,?,?,?,?)";
            ps = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getPassword());
            ps.setString(3, customer.getName());
            ps.setString(4, customer.getCity());
            ps.setString(5, customer.getPhone());
            
            int result = ps.executeUpdate();
            if (result > 0) {
                rs = ps.getGeneratedKeys();
                rs.next();
                customerId = rs.getInt(1);
                return customerId;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();
            rs.close();
        }

        return customerId;
    }
    
    public Customer verifyUser(String uname, String pwd) throws SQLException{
        
        try {
            conn = getConnection();
            String query = "select * from customer where username= ? and password=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            while(rs.next()){
                Customer c = new Customer();
                c.setName(rs.getString("name"));
                c.setCity(rs.getString("city"));
                c.setCustomerID(rs.getInt("customerId"));
                c.setPhone(rs.getString("phone"));
                c.setUsername(rs.getString("username"));
                c.setPassword(rs.getString("password"));
                return c;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close(conn);
            rs.close();
            ps.close();
        }
        return null;
    }

}
